/* Generated By:JavaCC: Do not edit this line. DShellParserImpl.java */
package org.doovos.shell.parser;

import org.doovos.shell.parser.nodes.*;

class DShellParserImpl implements DShellParserImplConstants {
    private NodeTree tree = new NodeTree();

    /* Production 1 */
    final public Node parse() throws ParseException {
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case IF:
            case WHILE:
            case GOTO:
            case LABEL:
            case OP_EQ:
            case LACC:
            case NEWLINE:
            case ITEM_STRING_DBL:
            case ITEM_STRING_SMP:
            case ITEM_STRING_ANTI:
            case ITEM_VAR:
            case ITEM_NAME:
                label_1:
                while (true) {
                    switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case NEWLINE:
                            ;
                            break;
                        default:
                            jj_la1[0] = jj_gen;
                            break label_1;
                    }
                    jj_consume_token(NEWLINE);
                }
                block();
                jj_consume_token(0);
                Node node = tree.pop();
            {
                if (true) return node;
            }
            break;
            case 0:
                jj_consume_token(0);
            {
                if (true) return null;
            }
            break;
            default:
                jj_la1[1] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
        throw new Error("Missing return statement in function");
    }

    final public void commandItem() throws ParseException {
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case OP_EQ:
                jj_consume_token(OP_EQ);
                ((CommandNode) tree.peek()).items.add(new CommandItemNode(new ItemNode(token)));
                break;
            case ITEM_NAME:
                jj_consume_token(ITEM_NAME);
                ((CommandNode) tree.peek()).items.add(new CommandItemNode(new ItemNode(token)));
                break;
            case ITEM_STRING_DBL:
                jj_consume_token(ITEM_STRING_DBL);
                ((CommandNode) tree.peek()).items.add(new CommandItemNode(new StringDoubleCotedNode(token)));
                break;
            case ITEM_STRING_SMP:
                jj_consume_token(ITEM_STRING_SMP);
                ((CommandNode) tree.peek()).items.add(new CommandItemNode(new StringSimpleCotedNode(token)));
                break;
            case ITEM_STRING_ANTI:
                jj_consume_token(ITEM_STRING_ANTI);
                ((CommandNode) tree.peek()).items.add(new CommandItemNode(new StringAntiCotedNode(token)));
                break;
            case ITEM_VAR:
                jj_consume_token(ITEM_VAR);
                ((CommandNode) tree.peek()).items.add(new CommandItemNode(new VarDollarNode(token)));
                break;
            default:
                jj_la1[2] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    final public void ifblock() throws ParseException {
        jj_consume_token(IF);
        tree.push(new IfNode());
        jj_consume_token(LPAR);
        block();
        Node bnode = tree.pop();
        IfNode ifnode = (IfNode) tree.peek();
        ifnode.conditionNode = bnode;
        jj_consume_token(RPAR);
        jj_consume_token(LACC);
        block();
        jj_consume_token(RACC);
        Node bnode1 = tree.pop();
        IfNode ifnode1 = (IfNode) tree.peek();
        ifnode1.thenNode = bnode1;
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case ELSE:
                jj_consume_token(ELSE);
                jj_consume_token(LACC);
                block();
                jj_consume_token(RACC);
                Node bnode2 = tree.pop();
                IfNode ifnode2 = (IfNode) tree.peek();
                ifnode2.thenNode = bnode2;
                break;
            default:
                jj_la1[3] = jj_gen;
                ;
        }
    }

    final public void whileblock() throws ParseException {
        jj_consume_token(WHILE);
        tree.push(new WhileNode());
        jj_consume_token(LPAR);
        block();
        Node bnode = tree.pop();
        WhileNode ifnode = (WhileNode) tree.peek();
        ifnode.conditionNode = bnode;
        jj_consume_token(RPAR);
        jj_consume_token(LACC);
        block();
        jj_consume_token(RACC);
        Node bnode1 = tree.pop();
        WhileNode ifnode1 = (WhileNode) tree.peek();
        ifnode1.whileNode = bnode1;
    }

    final public void gotoblock() throws ParseException {
        jj_consume_token(GOTO);
        jj_consume_token(ITEM_NAME);
        tree.push(new GotoNode(token));
    }

    final public void labelblock() throws ParseException {
        jj_consume_token(LABEL);
        jj_consume_token(ITEM_NAME);
        tree.push(new LabelNode(token));
    }

    final public void block() throws ParseException {
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case OP_EQ:
            case ITEM_STRING_DBL:
            case ITEM_STRING_SMP:
            case ITEM_STRING_ANTI:
            case ITEM_VAR:
            case ITEM_NAME:
                command();
                break;
            case IF:
                ifblock();
                break;
            case WHILE:
                whileblock();
                break;
            case GOTO:
                gotoblock();
                break;
            case LABEL:
                labelblock();
                break;
            case LACC:
                jj_consume_token(LACC);
                label_2:
                while (true) {
                    switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case NEWLINE:
                            ;
                            break;
                        default:
                            jj_la1[4] = jj_gen;
                            break label_2;
                    }
                    jj_consume_token(NEWLINE);
                }
                block();
                jj_consume_token(RACC);
                label_3:
                while (true) {
                    switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case NEWLINE:
                            ;
                            break;
                        default:
                            jj_la1[5] = jj_gen;
                            break label_3;
                    }
                    jj_consume_token(NEWLINE);
                }
                Node n = (Node) tree.pop();
                ((CommandNode) tree.peek()).items.add(new CommandItemNode(n));
                break;
            default:
                jj_la1[6] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case IF:
            case WHILE:
            case GOTO:
            case LABEL:
            case OP_EQ:
            case OP_AND2:
            case OP_THEN:
            case OP_AT:
            case OP_AT2:
            case OP_VDASH:
            case OP_VDASH2:
            case OP_LT:
            case OP_LT2:
            case OP_LET:
            case OP_GT:
            case OP_GT2:
            case OP_GET:
            case LACC:
            case ITEM_STRING_DBL:
            case ITEM_STRING_SMP:
            case ITEM_STRING_ANTI:
            case ITEM_VAR:
            case ITEM_NAME:
                switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                    case OP_AND2:
                    case OP_THEN:
                    case OP_AT:
                    case OP_AT2:
                    case OP_VDASH:
                    case OP_VDASH2:
                    case OP_LT:
                    case OP_LT2:
                    case OP_LET:
                    case OP_GT:
                    case OP_GT2:
                    case OP_GET:
                        binop();
                        label_4:
                        while (true) {
                            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                                case NEWLINE:
                                    ;
                                    break;
                                default:
                                    jj_la1[7] = jj_gen;
                                    break label_4;
                            }
                            jj_consume_token(NEWLINE);
                        }
                        block();
                    {
                        Node cmd2 = tree.pop();
                        TokenNode op = (TokenNode) tree.pop();
                        Node cmd1 = tree.pop();
                        tree.push(new BinoOp(op.getToken().image, cmd1, cmd2));
                    }
                    break;
                    case IF:
                    case WHILE:
                    case GOTO:
                    case LABEL:
                    case OP_EQ:
                    case LACC:
                    case ITEM_STRING_DBL:
                    case ITEM_STRING_SMP:
                    case ITEM_STRING_ANTI:
                    case ITEM_VAR:
                    case ITEM_NAME:
                        block();
                    {
                        Node cmd2 = tree.pop();
                        Node cmd1 = tree.pop();
                        tree.push(new BinoOp(";", cmd1, cmd2));
                    }
                    break;
                    default:
                        jj_la1[8] = jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                }
                break;
            default:
                jj_la1[9] = jj_gen;
                ;
        }

    }

    final public void command() throws ParseException {
        tree.push(new CommandNode());
        label_5:
        while (true) {
            commandItem();
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case OP_EQ:
                case ITEM_STRING_DBL:
                case ITEM_STRING_SMP:
                case ITEM_STRING_ANTI:
                case ITEM_VAR:
                case ITEM_NAME:
                    ;
                    break;
                default:
                    jj_la1[10] = jj_gen;
                    break label_5;
            }
        }
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case USING:
                commandUsing();
                break;
            default:
                jj_la1[11] = jj_gen;
                ;
        }
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case RED_IN:
            case RED_OUT_APP:
            case RED_ERR_APP:
            case RED_OUT:
            case RED_ERR:
                commandRedirect();
                break;
            default:
                jj_la1[12] = jj_gen;
                ;
        }
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case OP_AND:
                jj_consume_token(OP_AND);
                CommandNode c = (CommandNode) tree.peek();
                c.nowait = true;
                break;
            default:
                jj_la1[13] = jj_gen;
                ;
        }
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case OP_COMMA:
            case NEWLINE:
                label_6:
                while (true) {
                    switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case NEWLINE:
                            jj_consume_token(NEWLINE);
                            break;
                        case OP_COMMA:
                            jj_consume_token(OP_COMMA);
                            break;
                        default:
                            jj_la1[14] = jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                    }
                    switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                        case OP_COMMA:
                        case NEWLINE:
                            ;
                            break;
                        default:
                            jj_la1[15] = jj_gen;
                            break label_6;
                    }
                }
                break;
            case 0:
                jj_consume_token(0);
                break;
            default:
                jj_la1[16] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
        tree.peek();
    }

    final public void commandUsing() throws ParseException {
        jj_consume_token(USING);
        label_7:
        while (true) {
            commandUsingItem();
            jj_consume_token(OP_EQ);
            commandUsingItem();
            ItemNode b = (ItemNode) tree.pop();
            ItemNode a = (ItemNode) tree.pop();
            CommandNode c = (CommandNode) tree.pop();
            c.usingItems.add(new CommandUsingItemNode(a, b));
            tree.push(c);
            switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
                case ITEM_NAME:
                    ;
                    break;
                default:
                    jj_la1[17] = jj_gen;
                    break label_7;
            }
        }
    }

    final public void commandUsingItem() throws ParseException {
        jj_consume_token(ITEM_NAME);
        tree.push(new ItemNode(token));
    }

    final public void commandRedirect() throws ParseException {
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case RED_IN:
                jj_consume_token(RED_IN);
                break;
            case RED_OUT:
                jj_consume_token(RED_OUT);
                break;
            case RED_ERR:
                jj_consume_token(RED_ERR);
                break;
            case RED_OUT_APP:
                jj_consume_token(RED_OUT_APP);
                break;
            case RED_ERR_APP:
                jj_consume_token(RED_ERR_APP);
                break;
            default:
                jj_la1[18] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
        tree.push(new TokenNode(token));
        System.out.println("commandRedirect : " + token.image);
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case ITEM_NAME:
                jj_consume_token(ITEM_NAME);
            {
                TokenNode red = (TokenNode) tree.pop();
                CommandNode cmd = (CommandNode) tree.peek();
                cmd.redirectItems.add(new CommandRedirectItemNode(red, new ItemNode(token)));
            }
            break;
            case ITEM_STRING_DBL:
                jj_consume_token(ITEM_STRING_DBL);
            {
                TokenNode red = (TokenNode) tree.pop();
                CommandNode cmd = (CommandNode) tree.peek();
                cmd.redirectItems.add(new CommandRedirectItemNode(red, new StringDoubleCotedNode(token)));
            }
            break;
            case ITEM_STRING_SMP:
                jj_consume_token(ITEM_STRING_SMP);
            {
                TokenNode red = (TokenNode) tree.pop();
                CommandNode cmd = (CommandNode) tree.peek();
                cmd.redirectItems.add(new CommandRedirectItemNode(red, new StringSimpleCotedNode(token)));
            }
            break;
            case ITEM_STRING_ANTI:
                jj_consume_token(ITEM_STRING_ANTI);
            {
                TokenNode red = (TokenNode) tree.pop();
                CommandNode cmd = (CommandNode) tree.peek();
                cmd.redirectItems.add(new CommandRedirectItemNode(red, new StringAntiCotedNode(token)));
            }
            break;
            case ITEM_VAR:
                jj_consume_token(ITEM_VAR);
            {
                TokenNode red = (TokenNode) tree.pop();
                CommandNode cmd = (CommandNode) tree.peek();
                cmd.redirectItems.add(new CommandRedirectItemNode(red, new VarDollarNode(token)));
            }
            break;
            default:
                jj_la1[19] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    final public void binop() throws ParseException {
        switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
            case OP_AND2:
                jj_consume_token(OP_AND2);
                break;
            case OP_THEN:
                jj_consume_token(OP_THEN);
                break;
            case OP_AT:
                jj_consume_token(OP_AT);
                break;
            case OP_AT2:
                jj_consume_token(OP_AT2);
                break;
            case OP_VDASH:
                jj_consume_token(OP_VDASH);
                break;
            case OP_VDASH2:
                jj_consume_token(OP_VDASH2);
                break;
            case OP_LT:
                jj_consume_token(OP_LT);
                break;
            case OP_LT2:
                jj_consume_token(OP_LT2);
                break;
            case OP_LET:
                jj_consume_token(OP_LET);
                break;
            case OP_GT:
                jj_consume_token(OP_GT);
                break;
            case OP_GT2:
                jj_consume_token(OP_GT2);
                break;
            case OP_GET:
                jj_consume_token(OP_GET);
                break;
            default:
                jj_la1[20] = jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
        tree.push(new TokenNode(token));
    }

    /**
     * Generated Token Manager.
     */
    public DShellParserImplTokenManager token_source;
    SimpleCharStream jj_input_stream;
    /**
     * Current token.
     */
    public Token token;
    /**
     * Next token.
     */
    public Token jj_nt;
    private int jj_ntk;
    private int jj_gen;
    final private int[] jj_la1 = new int[21];
    static private int[] jj_la1_0;
    static private int[] jj_la1_1;

    static {
        jj_la1_init_0();
        jj_la1_init_1();
    }

    private static void jj_la1_init_0() {
        jj_la1_0 = new int[]{0x0, 0x8001d5, 0x100, 0x8, 0x0, 0x0, 0x8001d4, 0x0, 0xfff9d4, 0xfff9d4, 0x100, 0x2, 0xf8000000, 0x400, 0x200, 0x200, 0x201, 0x0, 0xf8000000, 0x0, 0x7ff800,};
    }

    private static void jj_la1_init_1() {
        jj_la1_1 = new int[]{0x1, 0x3f, 0x3e, 0x0, 0x1, 0x1, 0x3e, 0x1, 0x3e, 0x3e, 0x3e, 0x0, 0x0, 0x0, 0x1, 0x1, 0x1, 0x20, 0x0, 0x3e, 0x0,};
    }

    /**
     * Constructor with InputStream.
     */
    public DShellParserImpl(java.io.InputStream stream) {
        this(stream, null);
    }

    /**
     * Constructor with InputStream and supplied encoding
     */
    public DShellParserImpl(java.io.InputStream stream, String encoding) {
        try {
            jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1);
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        token_source = new DShellParserImplTokenManager(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 21; i++) jj_la1[i] = -1;
    }

    /**
     * Reinitialise.
     */
    public void ReInit(java.io.InputStream stream) {
        ReInit(stream, null);
    }

    /**
     * Reinitialise.
     */
    public void ReInit(java.io.InputStream stream, String encoding) {
        try {
            jj_input_stream.ReInit(stream, encoding, 1, 1);
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        token_source.ReInit(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 21; i++) jj_la1[i] = -1;
    }

    /**
     * Constructor.
     */
    public DShellParserImpl(java.io.Reader stream) {
        jj_input_stream = new SimpleCharStream(stream, 1, 1);
        token_source = new DShellParserImplTokenManager(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 21; i++) jj_la1[i] = -1;
    }

    /**
     * Reinitialise.
     */
    public void ReInit(java.io.Reader stream) {
        jj_input_stream.ReInit(stream, 1, 1);
        token_source.ReInit(jj_input_stream);
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 21; i++) jj_la1[i] = -1;
    }

    /**
     * Constructor with generated Token Manager.
     */
    public DShellParserImpl(DShellParserImplTokenManager tm) {
        token_source = tm;
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 21; i++) jj_la1[i] = -1;
    }

    /**
     * Reinitialise.
     */
    public void ReInit(DShellParserImplTokenManager tm) {
        token_source = tm;
        token = new Token();
        jj_ntk = -1;
        jj_gen = 0;
        for (int i = 0; i < 21; i++) jj_la1[i] = -1;
    }

    private Token jj_consume_token(int kind) throws ParseException {
        Token oldToken;
        if ((oldToken = token).next != null) token = token.next;
        else token = token.next = token_source.getNextToken();
        jj_ntk = -1;
        if (token.kind == kind) {
            jj_gen++;
            return token;
        }
        token = oldToken;
        jj_kind = kind;
        throw generateParseException();
    }


    /**
     * Get the next Token.
     */
    final public Token getNextToken() {
        if (token.next != null) token = token.next;
        else token = token.next = token_source.getNextToken();
        jj_ntk = -1;
        jj_gen++;
        return token;
    }

    /**
     * Get the specific Token.
     */
    final public Token getToken(int index) {
        Token t = token;
        for (int i = 0; i < index; i++) {
            if (t.next != null) t = t.next;
            else t = t.next = token_source.getNextToken();
        }
        return t;
    }

    private int jj_ntk() {
        if ((jj_nt = token.next) == null)
            return (jj_ntk = (token.next = token_source.getNextToken()).kind);
        else
            return (jj_ntk = jj_nt.kind);
    }

    private java.util.List jj_expentries = new java.util.ArrayList();
    private int[] jj_expentry;
    private int jj_kind = -1;

    /**
     * Generate ParseException.
     */
    public ParseException generateParseException() {
        jj_expentries.clear();
        boolean[] la1tokens = new boolean[43];
        if (jj_kind >= 0) {
            la1tokens[jj_kind] = true;
            jj_kind = -1;
        }
        for (int i = 0; i < 21; i++) {
            if (jj_la1[i] == jj_gen) {
                for (int j = 0; j < 32; j++) {
                    if ((jj_la1_0[i] & (1 << j)) != 0) {
                        la1tokens[j] = true;
                    }
                    if ((jj_la1_1[i] & (1 << j)) != 0) {
                        la1tokens[32 + j] = true;
                    }
                }
            }
        }
        for (int i = 0; i < 43; i++) {
            if (la1tokens[i]) {
                jj_expentry = new int[1];
                jj_expentry[0] = i;
                jj_expentries.add(jj_expentry);
            }
        }
        int[][] exptokseq = new int[jj_expentries.size()][];
        for (int i = 0; i < jj_expentries.size(); i++) {
            exptokseq[i] = (int[]) jj_expentries.get(i);
        }
        return new ParseException(token, exptokseq, tokenImage);
    }

    /**
     * Enable tracing.
     */
    final public void enable_tracing() {
    }

    /**
     * Disable tracing.
     */
    final public void disable_tracing() {
    }

}
