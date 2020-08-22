/**
 * ====================================================================
 *             Doovos (Distributed Object Oriented Operating System)
 *
 * Doovos is a new Open Source Distributed Object Oriented Operating System
 * Design and implementation based on the Java Platform.
 * Actually, it is a try for designing a distributed operation system in
 * top of existing centralized/network OS.
 * Designed OS will follow the object oriented architecture for redefining
 * all OS resources (memory,process,file system,device,...etc.) in a highly
 * distributed context.
 * Doovos is also a distributed Java virtual machine that implements JVM
 * specification on top the distributed resources context.
 *
 * Doovos Kernel is the heart of Doovos OS. It implements also the Doovos JVM
 * Doovos Kernel code is executed on host JVM
 *
 * Copyright (C) 2008-2010 Taha BEN SALAH
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 * ====================================================================
 */
package org.doovos.kernel.core.io.term.console;

import enigma.console.Console;
import enigma.console.TextAttributes;
import enigma.console.TextWindow;
import enigma.core.Enigma;
import org.doovos.kernel.api.io.term.KTerminalCommandInspecter;
import org.doovos.kernel.api.io.term.KTerminalCommandPossibilities;

import java.awt.datatransfer.DataFlavor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A Console for Doovos
 *
 * @author taha
 *         based on DefaultConsoleImpl by Ethan Royael Nicholas (<a href="mailto:ethan@ethannicholas.com">ethan@ethannicholas.com</a>)
 */
public class TextConsole implements Console {


    private final Object editLock = new Object();//new String("editLock");

    /**
     * true if we are currently accepting user input
     */
    private boolean editMode;

    /**
     * true to echo asterisks instead of the typed characters while in edit mode
     */
    private boolean passwordMode;

    private int cursorIndex;
    private StringBuffer enteredText = new StringBuffer();


    private CommadHistory commadHistory = new CommadHistoryImpl();
    private KTerminalCommandInspecter commandInspecter = new CommandInspecterImpl();


    /**
     * The TextAttributes used for stream & writer output.
     */
    private TextAttributes textAttributes = Enigma.getSystemTextAttributes("attributes.console.default");
    TextConsoleWindow window;

    private PrintWriter consoleWriter = new PrintWriter(new Writer() {
        public void close() {
        }


        public void flush() {
        }


        public void write(char c) {
            window.output(c, textAttributes);
        }


        public void write(char[] c, int offset, int length) {
            window.output(c, offset, length, textAttributes);
        }


        public void write(String str) {
            window.output(str, textAttributes);
        }
    });


    private PrintStream consolePrintStream = new PrintStream(new OutputStream() {
        public void close() {
            consoleWriter.close();
        }


        public void flush() {
            consoleWriter.flush();
        }


        public void write(int b) {
            consoleWriter.write((char) b);
        }


        public void write(byte[] b, int offset, int length) {
            consoleWriter.write(new String(b, offset, length));
        }


        public void write(byte[] b) {
            consoleWriter.write(new String(b));
        }
    });


    private InputStream consoleInputStream = new InputStream() {
        byte[] data;
        int offset;

        public int read() {
            if (data == null) {
                data = (readLine() + "\n").getBytes();
                offset = 0;
            }
            if (offset >= data.length) {
                data = null;
                return -1;
            }
            return data[offset++];
        }


        public int available() {
            return data != null ? data.length - offset : 0;
        }
    };


    private Reader consoleReader = new InputStreamReader(consoleInputStream);


    /**
     * Creates a <code>Console</code> wrapping the specified {@link enigma.console.TextWindow}.
     * <code>DefaultConsoleImpl</code> expects to be the sole manager of the
     * <code>TextWindow</code>; any further direct interaction with the
     * <code>TextWindow</code> may result in unspecified behavior.
     */
    public TextConsole(String title) {
        this(title, new TextConsoleWindow());
    }

    public TextConsole(String title, TextConsoleWindow w) {
        window = w;
        window.addKeyListener(createKeyListener());
        window.setCursorType(TextWindow.CURSOR_INVISIBLE);
        window.putClientProperty("TextConsole", this);
        setTitle(title == null ? "" : title);
    }

//    public TextConsole() {
//        this(null);
//    }

    public KTerminalCommandInspecter getCommadInspecter() {
        return commandInspecter;
    }

    public void setCommadInspecter(KTerminalCommandInspecter commandInspecter) {
        this.commandInspecter = commandInspecter;
    }

    public CommadHistory getCommadHistory() {
        return commadHistory;
    }

    public void setCommadHistory(CommadHistory commadHistory) {
        this.commadHistory = commadHistory;
    }

    public boolean isPasswordMode() {
        return passwordMode;
    }

    public void setPasswordMode(boolean passwordMode) {
        this.passwordMode = passwordMode;
    }

    protected KeyListener createKeyListener() {
        return new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB || e.getKeyChar() == KeyEvent.CHAR_UNDEFINED || e.getKeyCode() == KeyEvent.VK_DELETE) {
                    if (editMode) {
                        handleKeyPressed(e.getKeyCode(), e.getModifiers());
                    } else {
                        buffer(e);
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_V && e.getModifiers() == KeyEvent.CTRL_MASK) {
                    if (editMode) {
                        commandPaste();
                    }
                }
            }

            public void keyReleased(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.CHAR_UNDEFINED) {
                    if (editMode)
                        handleKeyReleased(e.getKeyCode());
                    else
                        buffer(e);
                }
            }

            public void keyTyped(KeyEvent e) {
                if (editMode)
                    handleKeyTyped(e.getKeyChar());
                else
                    buffer(e);
            }
        };
    }


    protected void buffer(KeyEvent e) {
    }


    protected void processBuffer() {
    }


    private void enterEditMode() {
        //assert Thread.holdsLock(editLock);
        window.setCursorType(TextWindow.CURSOR_INSERT);
        editMode = true;
        enteredText.setLength(0);
        cursorIndex = 0;
        commadHistory.setCurrentCommandRecall(commadHistory.size());
        commadHistory.add("");
        processBuffer();
    }


    private void exitEditMode() {
        //assert Thread.holdsLock(editLock);
        window.setCursorType(TextWindow.CURSOR_INVISIBLE);
        editMode = false;
        if (enteredText.length() > 0)
            commadHistory.add(enteredText.toString());
        else
            commadHistory.remove(commadHistory.size() - 1);
    }


    public synchronized String readLine() {
        String result;
        synchronized (editLock) {
            enterEditMode();
            try {
                editLock.wait();
                // exitEditMode is performed in event thread
            }
            catch (InterruptedException e) {
                //
            }
            result = enteredText.toString();
        }
        return result;
    }


    public synchronized String readPassword() {
        try {
            passwordMode = true;
            return readLine();
        }
        finally {
            passwordMode = false;
        }
    }


    protected void setCommandRecall(int newIndex) {
        commadHistory.set(commadHistory.getCurrentCommandRecall(), enteredText.toString());
        commadHistory.setCurrentCommandRecall(newIndex);
        int oldLength = enteredText.length();
        enteredText = new StringBuffer(oldLength);
        for (int i = 0; i < oldLength; i++)
            enteredText.append(' ');
        moveCursor(-cursorIndex);
        refreshEndOfString();
        enteredText = new StringBuffer(commadHistory.get(commadHistory.getCurrentCommandRecall()));
        refreshEndOfString();
        moveCursor(enteredText.length());
        //assert cursorIndex == enteredText.length() : "expected cursorIndex to be at end of string (length = " + enteredText.length() + ", cursorIndex = " + cursorIndex + ")";
    }


    public void commandRecallUp() {
        int newIndex = Math.max(0, commadHistory.getCurrentCommandRecall() - 1);
        setCommandRecall(newIndex);
    }

    public void commandPaste() {
        String s = enteredText.toString();
//        int x = cursorIndex;
        String cb = "";
        try {
            cb = String.valueOf(window.getToolkit().getSystemClipboard().getContents(null).getTransferData(DataFlavor.stringFlavor));
        } catch (Exception e) {
            //e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        if (cursorIndex <= 0) {
            s = cb + s;
        } else if (cursorIndex >= s.length()) {
            s = s + cb;
        } else {
            s = s.substring(0, cursorIndex) + cb + s.substring(cursorIndex);
        }
        enteredText = new StringBuffer(s);
        refreshEndOfString();
        moveCursor(cb.length());
    }

    public void commandInspect() {
        int oldLength = enteredText.length();
        String oldCommand = enteredText.toString();
        enteredText = new StringBuffer(oldLength);
        for (int i = 0; i < oldLength; i++)
            enteredText.append(' ');
        moveCursor(-cursorIndex);
        refreshEndOfString();
        KTerminalCommandPossibilities commandPossibilities = commandInspecter.inspectCommand(oldCommand, cursorIndex);
        if (commandPossibilities.getPossibilities().size() <= 1) {
            enteredText = new StringBuffer(
                    commandPossibilities.getPossibilities().size() == 0 ?
                            oldCommand : commandPossibilities.getPossibilities().toArray(new String[1])[0]
            );
            refreshEndOfString();
            moveCursor(enteredText.length());
        } else {
            getWriter().write(oldCommand + "\n");
            getWriter().write("Too many possibilities [" + commandPossibilities.getPossibilities().size() + "]\n");
            for (String s : commandPossibilities.getPossibilities()) {
                getWriter().write("\t " + s + "\n");
            }
            getWriter().write("\n");
            enteredText = new StringBuffer(
                    commandPossibilities.getMinimum()
                    //oldCommand
            );
            refreshEndOfString();
            moveCursor(enteredText.length());
        }
    }


    public void commandRecallDown() {
        int newIndex = Math.min(commadHistory.size() - 1, commadHistory.getCurrentCommandRecall() + 1);
        setCommandRecall(newIndex);
    }


    protected void refreshEndOfString() {
        window.setCursorType(TextWindow.CURSOR_INVISIBLE);
        if (!passwordMode) {
            window.output(enteredText.substring(cursorIndex));
        } else {
            int length = enteredText.length();
            for (int i = cursorIndex; i < length; i++)
                window.output('*', textAttributes);
        }
        window.output(' ');
        int delta = enteredText.length() - cursorIndex + 1;
        cursorIndex += delta;
        moveCursor(-delta);
        window.setCursorType(TextWindow.CURSOR_INSERT);
    }


    protected void handleKeyPressed(int keyCode, int modifiers) {
        switch (keyCode) {
            case KeyEvent.VK_V:
                if (modifiers == KeyEvent.VK_CONTROL) {
                    commandRecallUp();
                }
                break;
            case KeyEvent.VK_UP:
                commandRecallUp();
                break;
            case KeyEvent.VK_DOWN:
                commandRecallDown();
                break;
            case KeyEvent.VK_PAGE_UP:
                window.pageUp();
                break;
            case KeyEvent.VK_PAGE_DOWN:
                window.pageDown();
                break;
            case KeyEvent.VK_LEFT:
                if (cursorIndex > 0)
                    moveCursor(-1);
                break;
            case KeyEvent.VK_RIGHT:
                if (cursorIndex < enteredText.length())
                    moveCursor(1);
                break;
            case KeyEvent.VK_HOME:
                moveCursor(-cursorIndex);
                break;
            case KeyEvent.VK_END:
                moveCursor(enteredText.length() - cursorIndex);
                break;
            case KeyEvent.VK_TAB:
                commandInspect();
                break;
            case KeyEvent.VK_DELETE:
                if (cursorIndex < enteredText.length()) {
                    enteredText.deleteCharAt(cursorIndex);
                    refreshEndOfString();
                }
                break;
        }
        //assert cursorIndex >= 0 && cursorIndex <= enteredText.length() : "cursorIndex out of bounds";
    }


    protected void handleKeyReleased(int keyCode) {
        //assert cursorIndex >= 0 && cursorIndex <= enteredText.length() : "cursorIndex out of bounds";
    }


    protected void handleKeyTyped(char keyChar) {
        if (keyChar == 8) { // backspace
            if (cursorIndex > 0) {
                moveCursor(-1);
                enteredText.deleteCharAt(cursorIndex);
                refreshEndOfString();
            }
        } else if (keyChar == 27) // escape
            clearEnteredText();
        else if (keyChar == '\n') { // newline
            moveCursor(enteredText.length() - cursorIndex);
            window.output('\n', textAttributes);
            synchronized (editLock) {
                editLock.notify();
                exitEditMode();
            }
        } else if (keyChar > 31) { // non-control character
            enteredText.insert(cursorIndex++, keyChar);

            // this moves the cursor, so no moveCursor(1) needed
            if (!passwordMode)
                window.outputImmediately(keyChar, textAttributes);
            else
                window.outputImmediately('*', textAttributes);

            if (cursorIndex < enteredText.length())
                refreshEndOfString();
        }

        //assert cursorIndex >= 0 && cursorIndex <= enteredText.length() : "cursorIndex out of bounds";
    }


    private void clearEnteredText() {
        moveCursor(-cursorIndex);
        for (int i = 0; i < enteredText.length(); i++)
            enteredText.setCharAt(i, ' ');
        refreshEndOfString();
        enteredText.setLength(0);
    }


    private void moveCursor(int delta) {
        cursorIndex += delta;
        int newCursorX = window.getCursorX() + delta;
        int newCursorY = window.getCursorY();
        while (newCursorX < 0) {
            newCursorY--;
            newCursorX += window.getColumns();
        }
        while (newCursorX >= window.getColumns()) {
            newCursorY++;
            newCursorX -= window.getColumns();
        }
        while (newCursorY >= window.getRows()) {
            window.insertRow(window.getRows() - 1);
            newCursorY--;
        }
        window.setCursorPosition(newCursorX, newCursorY);
    }


    public TextAttributes getTextAttributes() {
        return textAttributes;
    }


    public void setTextAttributes(TextAttributes textAttributes) {
        this.textAttributes = textAttributes;
    }


    public Reader getReader() {
        return consoleReader;
    }


    public PrintWriter getWriter() {
        return consoleWriter;
    }


    public InputStream getInputStream() {
        return consoleInputStream;
    }


    public PrintStream getOutputStream() {
        return consolePrintStream;
    }


    public boolean isTextWindowAvailable() {
        return true;
    }


    public TextWindow getTextWindow() {
        return window;
    }


    public String getTitle() {
        return window.getTitle();
    }


    public void setTitle(String title) {
        window.setTitle(title);
    }

    public static interface CommadHistory {

        public int size();

        public void add(String command);

        public int getCurrentCommandRecall();

        public void setCurrentCommandRecall(int currentCommandRecall);

        void set(int pos, String command);

        void remove(int pos);

        String get(int pos);
    }

    public static class CommandInspecterImpl implements KTerminalCommandInspecter {
        String[] cmds = {"list", "help"};

        public KTerminalCommandPossibilities inspectCommand(String command, int cursorIndex) {
            KTerminalCommandPossibilities possibilities = new CommandPossibilitiesImplK();
            for (String cmd : cmds) {
                if (cmd.startsWith(command)) {
                    possibilities.getPossibilities().add(cmd);
                }
            }
            return possibilities;
        }
    }

    public static class CommadHistoryImpl implements CommadHistory {
        /**
         * The index of the currently displayed command from the command buffer.
         */
        private int currentCommandRecall;

        /**
         * A list of all remembered commands.
         */
        private List<String> commandRecallBuffer = new ArrayList<String>();

        public void enterEditMode() {
            currentCommandRecall = commandRecallBuffer.size();
            commandRecallBuffer.add("");
        }

        public int size() {
            return commandRecallBuffer.size();
        }

        public void add(String command) {
            commandRecallBuffer.remove(command);
            commandRecallBuffer.add(command);
            currentCommandRecall = commandRecallBuffer.size() - 1;
        }

        public void set(int pos, String command) {
            if (pos >= commandRecallBuffer.size() || pos < 0) {
                add(command);
            } else {
                commandRecallBuffer.set(pos, command);
                currentCommandRecall = pos;
            }
        }

        public String get(int pos) {
            return commandRecallBuffer.get(pos);
        }

        public void remove(int pos) {
            commandRecallBuffer.remove(pos);
            currentCommandRecall = pos < commandRecallBuffer.size() ? pos : commandRecallBuffer.size() - 1;
        }

        public int getCurrentCommandRecall() {
            return currentCommandRecall;
        }

        public void setCurrentCommandRecall(int currentCommandRecall) {
            this.currentCommandRecall = currentCommandRecall;
        }
    }

    public void clear() {
        window.clearWindow();
    }

    public TextConsoleWindow getWindow() {
        return window;
    }


}