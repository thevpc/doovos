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
 * Doovos JAVA JNI is the native implementation (in Doovos sens so in java)
 * of the hotspot java libraries (provided by sun).
 * JNI code is executed on host JVM (in doovos kernel mode)
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
package jniperf.java.lang;

import org.doovos.kernel.api.jvm.jni.JNICLASS;
import org.doovos.kernel.api.jvm.jni.JNIEnv;
import org.doovos.kernel.api.jvm.jni.JNICALL;

import java.rmi.RemoteException;

/**
 * Created by IntelliJ IDEA.
 * User: vpc
 * Date: 10 mai 2009
 * Time: 23:20:21
 * To change this template use File | Settings | File Templates.
 */
@JNICLASS(value="java.lang.Character",forceJNI=true)
public class CharacterJNIPerf {
    @JNICALL
    public static boolean isSurrogatePair(JNIEnv env,char high, char low) {
        return Character.isSurrogatePair(high,low);
    }

    @JNICALL
    public static int codePointAt(JNIEnv env,char[] a, int index) throws RemoteException {
	    return Character.codePointAt(a, index);
    }


    @JNICALL
    public static int codePointAt(JNIEnv env,char[] a,  int index, int limit) throws RemoteException {
        return Character.codePointAt(a,index,limit);
    }

    @JNICALL
    public static int codePointBefore(JNIEnv env, char[] a,  int index) throws RemoteException {
        return Character.codePointBefore(a,index);
    }

    @JNICALL
    public static int codePointBefore(JNIEnv env, char[] a,  int index, int start) throws RemoteException {
        return Character.codePointBefore(a,index,start);
    }

    @JNICALL
    public static int toChars(JNIEnv env,int codePoint, char[] dst, int dstIndex) throws RemoteException {
        return Character.toChars(codePoint,dst,dstIndex);
    }

//    public static int codePointCount(char[] a, int offset, int count) {
//	if (count > a.length - offset || offset < 0 || count < 0) {
//	    throw new IndexOutOfBoundsException();
//	}
//	return codePointCountImpl(a, offset, count);
//    }
//
//    public static int offsetByCodePoints(CharSequence seq, int index,
//					 int codePointOffset) {
//	int length = seq.length();
//	if (index < 0 || index > length) {
//	    throw new IndexOutOfBoundsException();
//	}
//
//	int x = index;
//	if (codePointOffset >= 0) {
//	    int i;
//	    for (i = 0; x < length && i < codePointOffset; i++) {
//		if (isHighSurrogate(seq.charAt(x++))) {
//		    if (x < length && isLowSurrogate(seq.charAt(x))) {
//			x++;
//		    }
//		}
//	    }
//	    if (i < codePointOffset) {
//		throw new IndexOutOfBoundsException();
//	    }
//	} else {
//	    int i;
//	    for (i = codePointOffset; x > 0 && i < 0; i++) {
//		if (isLowSurrogate(seq.charAt(--x))) {
//		    if (x > 0 && isHighSurrogate(seq.charAt(x-1))) {
//			x--;
//		    }
//		}
//	    }
//	    if (i < 0) {
//		throw new IndexOutOfBoundsException();
//	    }
//	}
//	return x;
//    }
//
//    public static int offsetByCodePoints(char[] a, int start, int count,
//					 int index, int codePointOffset) {
//	if (count > a.length-start || start < 0 || count < 0
//	    || index < start || index > start+count) {
//	    throw new IndexOutOfBoundsException();
//	}
//	return offsetByCodePointsImpl(a, start, count, index, codePointOffset);
//    }
//
//
//    public static boolean isLowerCase(char ch) {
//        return isLowerCase((int)ch);
//    }
//
//    /**
//     * Determines if the specified character (Unicode code point) is a
//     * lowercase character.
//     * <p>
//     * A character is lowercase if its general category type, provided
//     * by {@link Character#getType getType(codePoint)}, is
//     * <code>LOWERCASE_LETTER</code>.
//     * <p>
//     * The following are examples of lowercase characters:
//     * <p><blockquote><pre>
//     * a b c d e f g h i j k l m n o p q r s t u v w x y z
//     * '&#92;u00DF' '&#92;u00E0' '&#92;u00E1' '&#92;u00E2' '&#92;u00E3' '&#92;u00E4' '&#92;u00E5' '&#92;u00E6'
//     * '&#92;u00E7' '&#92;u00E8' '&#92;u00E9' '&#92;u00EA' '&#92;u00EB' '&#92;u00EC' '&#92;u00ED' '&#92;u00EE'
//     * '&#92;u00EF' '&#92;u00F0' '&#92;u00F1' '&#92;u00F2' '&#92;u00F3' '&#92;u00F4' '&#92;u00F5' '&#92;u00F6'
//     * '&#92;u00F8' '&#92;u00F9' '&#92;u00FA' '&#92;u00FB' '&#92;u00FC' '&#92;u00FD' '&#92;u00FE' '&#92;u00FF'
//     * </pre></blockquote>
//     * <p> Many other Unicode characters are lowercase too.
//     *
//     * @param   codePoint the character (Unicode code point) to be tested.
//     * @return  <code>true</code> if the character is lowercase;
//     *          <code>false</code> otherwise.
//     * @see     java.lang.Character#isLowerCase(int)
//     * @see     java.lang.Character#isTitleCase(int)
//     * @see     java.lang.Character#toLowerCase(int)
//     * @see     java.lang.Character#getType(int)
//     * @since   1.5
//     */
//    public static boolean isLowerCase(int codePoint) {
//        boolean bLowerCase = false;
//
//        // codePoint must be in the valid range of codepoints
//        if (codePoint >= MIN_CODE_POINT && codePoint <= FAST_PATH_MAX) {
//            bLowerCase = CharacterDataLatin1.isLowerCase(codePoint);
//        } else {
//            int plane = getPlane(codePoint);
//            switch(plane) {
//            case(0):
//                bLowerCase = CharacterData00.isLowerCase(codePoint);
//                break;
//            case(1):
//                bLowerCase = CharacterData01.isLowerCase(codePoint);
//                break;
//            case(2):
//                bLowerCase = CharacterData02.isLowerCase(codePoint);
//                break;
//            case(3): // Undefined
//            case(4): // Undefined
//            case(5): // Undefined
//            case(6): // Undefined
//            case(7): // Undefined
//            case(8): // Undefined
//            case(9): // Undefined
//            case(10): // Undefined
//            case(11): // Undefined
//            case(12): // Undefined
//            case(13): // Undefined
//                bLowerCase = CharacterDataUndefined.isLowerCase(codePoint);
//                break;
//            case(14):
//                bLowerCase = CharacterData0E.isLowerCase(codePoint);
//                break;
//            case(15): // Private Use
//            case(16): // Private Use
//                bLowerCase = CharacterDataPrivateUse.isLowerCase(codePoint);
//                break;
//            default:
//                // the argument's plane is invalid, and thus is an invalid codepoint
//                // bLowerCase remains false
//                break;
//            }
//        }
//        return bLowerCase;
//    }
//
//   /**
//     * Determines if the specified character is an uppercase character.
//     * <p>
//     * A character is uppercase if its general category type, provided by
//     * <code>Character.getType(ch)</code>, is <code>UPPERCASE_LETTER</code>.
//     * <p>
//     * The following are examples of uppercase characters:
//     * <p><blockquote><pre>
//     * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
//     * '&#92;u00C0' '&#92;u00C1' '&#92;u00C2' '&#92;u00C3' '&#92;u00C4' '&#92;u00C5' '&#92;u00C6' '&#92;u00C7'
//     * '&#92;u00C8' '&#92;u00C9' '&#92;u00CA' '&#92;u00CB' '&#92;u00CC' '&#92;u00CD' '&#92;u00CE' '&#92;u00CF'
//     * '&#92;u00D0' '&#92;u00D1' '&#92;u00D2' '&#92;u00D3' '&#92;u00D4' '&#92;u00D5' '&#92;u00D6' '&#92;u00D8'
//     * '&#92;u00D9' '&#92;u00DA' '&#92;u00DB' '&#92;u00DC' '&#92;u00DD' '&#92;u00DE'
//     * </pre></blockquote>
//     * <p> Many other Unicode characters are uppercase too.<p>
//     *
//     * <p><b>Note:</b> This method cannot handle <a
//     * href="#supplementary"> supplementary characters</a>. To support
//     * all Unicode characters, including supplementary characters, use
//     * the {@link #isUpperCase(int)} method.
//     *
//     * @param   ch   the character to be tested.
//     * @return  <code>true</code> if the character is uppercase;
//     *          <code>false</code> otherwise.
//     * @see     java.lang.Character#isLowerCase(char)
//     * @see     java.lang.Character#isTitleCase(char)
//     * @see     java.lang.Character#toUpperCase(char)
//     * @see     java.lang.Character#getType(char)
//     * @since   1.0
//     */
//    public static boolean isUpperCase(char ch) {
//        return isUpperCase((int)ch);
//    }
//
//    /**
//     * Determines if the specified character (Unicode code point) is an uppercase character.
//     * <p>
//     * A character is uppercase if its general category type, provided by
//     * {@link Character#getType(int) getType(codePoint)}, is <code>UPPERCASE_LETTER</code>.
//     * <p>
//     * The following are examples of uppercase characters:
//     * <p><blockquote><pre>
//     * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
//     * '&#92;u00C0' '&#92;u00C1' '&#92;u00C2' '&#92;u00C3' '&#92;u00C4' '&#92;u00C5' '&#92;u00C6' '&#92;u00C7'
//     * '&#92;u00C8' '&#92;u00C9' '&#92;u00CA' '&#92;u00CB' '&#92;u00CC' '&#92;u00CD' '&#92;u00CE' '&#92;u00CF'
//     * '&#92;u00D0' '&#92;u00D1' '&#92;u00D2' '&#92;u00D3' '&#92;u00D4' '&#92;u00D5' '&#92;u00D6' '&#92;u00D8'
//     * '&#92;u00D9' '&#92;u00DA' '&#92;u00DB' '&#92;u00DC' '&#92;u00DD' '&#92;u00DE'
//     * </pre></blockquote>
//     * <p> Many other Unicode characters are uppercase too.<p>
//     *
//     * @param   codePoint the character (Unicode code point) to be tested.
//     * @return  <code>true</code> if the character is uppercase;
//     *          <code>false</code> otherwise.
//     * @see     java.lang.Character#isLowerCase(int)
//     * @see     java.lang.Character#isTitleCase(int)
//     * @see     java.lang.Character#toUpperCase(int)
//     * @see     java.lang.Character#getType(int)
//     * @since   1.5
//     */
//    public static boolean isUpperCase(int codePoint) {
//        boolean bUpperCase = false;
//
//        if (codePoint >= MIN_CODE_POINT && codePoint <= FAST_PATH_MAX) {
//            bUpperCase = CharacterDataLatin1.isUpperCase(codePoint);
//        } else {
//            int plane = getPlane(codePoint);
//            switch(plane) {
//            case(0):
//                bUpperCase = CharacterData00.isUpperCase(codePoint);
//                break;
//            case(1):
//                bUpperCase = CharacterData01.isUpperCase(codePoint);
//                break;
//            case(2):
//                bUpperCase = CharacterData02.isUpperCase(codePoint);
//                break;
//            case(3): // Undefined
//            case(4): // Undefined
//            case(5): // Undefined
//            case(6): // Undefined
//            case(7): // Undefined
//            case(8): // Undefined
//            case(9): // Undefined
//            case(10): // Undefined
//            case(11): // Undefined
//            case(12): // Undefined
//            case(13): // Undefined
//                bUpperCase = CharacterDataUndefined.isUpperCase(codePoint);
//                break;
//            case(14):
//                bUpperCase = CharacterData0E.isUpperCase(codePoint);
//                break;
//            case(15): // Private Use
//            case(16): // Private Use
//                bUpperCase = CharacterDataPrivateUse.isUpperCase(codePoint);
//                break;
//            default:
//                // the argument's plane is invalid, and thus is an invalid codepoint
//                // bUpperCase remains false;
//                break;
//            }
//        }
//        return bUpperCase;
//    }
//
//    /**
//     * Determines if the specified character is a titlecase character.
//     * <p>
//     * A character is a titlecase character if its general
//     * category type, provided by <code>Character.getType(ch)</code>,
//     * is <code>TITLECASE_LETTER</code>.
//     * <p>
//     * Some characters look like pairs of Latin letters. For example, there
//     * is an uppercase letter that looks like "LJ" and has a corresponding
//     * lowercase letter that looks like "lj". A third form, which looks like "Lj",
//     * is the appropriate form to use when rendering a word in lowercase
//     * with initial capitals, as for a book title.
//     * <p>
//     * These are some of the Unicode characters for which this method returns
//     * <code>true</code>:
//     * <ul>
//     * <li><code>LATIN CAPITAL LETTER D WITH SMALL LETTER Z WITH CARON</code>
//     * <li><code>LATIN CAPITAL LETTER L WITH SMALL LETTER J</code>
//     * <li><code>LATIN CAPITAL LETTER N WITH SMALL LETTER J</code>
//     * <li><code>LATIN CAPITAL LETTER D WITH SMALL LETTER Z</code>
//     * </ul>
//     * <p> Many other Unicode characters are titlecase too.<p>
//     *
//     * <p><b>Note:</b> This method cannot handle <a
//     * href="#supplementary"> supplementary characters</a>. To support
//     * all Unicode characters, including supplementary characters, use
//     * the {@link #isTitleCase(int)} method.
//     *
//     * @param   ch   the character to be tested.
//     * @return  <code>true</code> if the character is titlecase;
//     *          <code>false</code> otherwise.
//     * @see     java.lang.Character#isLowerCase(char)
//     * @see     java.lang.Character#isUpperCase(char)
//     * @see     java.lang.Character#toTitleCase(char)
//     * @see     java.lang.Character#getType(char)
//     * @since   1.0.2
//     */
//    public static boolean isTitleCase(char ch) {
//        return isTitleCase((int)ch);
//    }
//
//    /**
//     * Determines if the specified character (Unicode code point) is a titlecase character.
//     * <p>
//     * A character is a titlecase character if its general
//     * category type, provided by {@link Character#getType(int) getType(codePoint)},
//     * is <code>TITLECASE_LETTER</code>.
//     * <p>
//     * Some characters look like pairs of Latin letters. For example, there
//     * is an uppercase letter that looks like "LJ" and has a corresponding
//     * lowercase letter that looks like "lj". A third form, which looks like "Lj",
//     * is the appropriate form to use when rendering a word in lowercase
//     * with initial capitals, as for a book title.
//     * <p>
//     * These are some of the Unicode characters for which this method returns
//     * <code>true</code>:
//     * <ul>
//     * <li><code>LATIN CAPITAL LETTER D WITH SMALL LETTER Z WITH CARON</code>
//     * <li><code>LATIN CAPITAL LETTER L WITH SMALL LETTER J</code>
//     * <li><code>LATIN CAPITAL LETTER N WITH SMALL LETTER J</code>
//     * <li><code>LATIN CAPITAL LETTER D WITH SMALL LETTER Z</code>
//     * </ul>
//     * <p> Many other Unicode characters are titlecase too.<p>
//     *
//     * @param   codePoint the character (Unicode code point) to be tested.
//     * @return  <code>true</code> if the character is titlecase;
//     *          <code>false</code> otherwise.
//     * @see     java.lang.Character#isLowerCase(int)
//     * @see     java.lang.Character#isUpperCase(int)
//     * @see     java.lang.Character#toTitleCase(int)
//     * @see     java.lang.Character#getType(int)
//     * @since   1.5
//     */
//    public static boolean isTitleCase(int codePoint) {
//        boolean bTitleCase = false;
//
//        if (codePoint >= MIN_CODE_POINT && codePoint <= FAST_PATH_MAX) {
//            bTitleCase = CharacterDataLatin1.isTitleCase(codePoint);
//        } else {
//            int plane = getPlane(codePoint);
//            switch(plane) {
//            case(0):
//                bTitleCase = CharacterData00.isTitleCase(codePoint);
//                break;
//            case(1):
//                bTitleCase = CharacterData01.isTitleCase(codePoint);
//                break;
//            case(2):
//                bTitleCase = CharacterData02.isTitleCase(codePoint);
//                break;
//            case(3): // Undefined
//            case(4): // Undefined
//            case(5): // Undefined
//            case(6): // Undefined
//            case(7): // Undefined
//            case(8): // Undefined
//            case(9): // Undefined
//            case(10): // Undefined
//            case(11): // Undefined
//            case(12): // Undefined
//            case(13): // Undefined
//                bTitleCase = CharacterDataUndefined.isTitleCase(codePoint);
//                break;
//            case(14):
//                bTitleCase = CharacterData0E.isTitleCase(codePoint);
//                break;
//            case(15): // Private Use
//            case(16): // Private Use
//                bTitleCase = CharacterDataPrivateUse.isTitleCase(codePoint);
//                break;
//            default:
//                // the argument's plane is invalid, and thus is an invalid codepoint
//                // bTitleCase remains false;
//                break;
//            }
//        }
//        return bTitleCase;
//    }
//
//    /**
//     * Determines if the specified character is a digit.
//     * <p>
//     * A character is a digit if its general category type, provided
//     * by <code>Character.getType(ch)</code>, is
//     * <code>DECIMAL_DIGIT_NUMBER</code>.
//     * <p>
//     * Some Unicode character ranges that contain digits:
//     * <ul>
//     * <li><code>'&#92;u0030'</code> through <code>'&#92;u0039'</code>,
//     *     ISO-LATIN-1 digits (<code>'0'</code> through <code>'9'</code>)
//     * <li><code>'&#92;u0660'</code> through <code>'&#92;u0669'</code>,
//     *     Arabic-Indic digits
//     * <li><code>'&#92;u06F0'</code> through <code>'&#92;u06F9'</code>,
//     *     Extended Arabic-Indic digits
//     * <li><code>'&#92;u0966'</code> through <code>'&#92;u096F'</code>,
//     *     Devanagari digits
//     * <li><code>'&#92;uFF10'</code> through <code>'&#92;uFF19'</code>,
//     *     Fullwidth digits
//     * </ul>
//     *
//     * Many other character ranges contain digits as well.
//     *
//     * <p><b>Note:</b> This method cannot handle <a
//     * href="#supplementary"> supplementary characters</a>. To support
//     * all Unicode characters, including supplementary characters, use
//     * the {@link #isDigit(int)} method.
//     *
//     * @param   ch   the character to be tested.
//     * @return  <code>true</code> if the character is a digit;
//     *          <code>false</code> otherwise.
//     * @see     java.lang.Character#digit(char, int)
//     * @see     java.lang.Character#forDigit(int, int)
//     * @see     java.lang.Character#getType(char)
//     */
//    public static boolean isDigit(char ch) {
//        return isDigit((int)ch);
//    }
//
//    /**
//     * Determines if the specified character (Unicode code point) is a digit.
//     * <p>
//     * A character is a digit if its general category type, provided
//     * by {@link Character#getType(int) getType(codePoint)}, is
//     * <code>DECIMAL_DIGIT_NUMBER</code>.
//     * <p>
//     * Some Unicode character ranges that contain digits:
//     * <ul>
//     * <li><code>'&#92;u0030'</code> through <code>'&#92;u0039'</code>,
//     *     ISO-LATIN-1 digits (<code>'0'</code> through <code>'9'</code>)
//     * <li><code>'&#92;u0660'</code> through <code>'&#92;u0669'</code>,
//     *     Arabic-Indic digits
//     * <li><code>'&#92;u06F0'</code> through <code>'&#92;u06F9'</code>,
//     *     Extended Arabic-Indic digits
//     * <li><code>'&#92;u0966'</code> through <code>'&#92;u096F'</code>,
//     *     Devanagari digits
//     * <li><code>'&#92;uFF10'</code> through <code>'&#92;uFF19'</code>,
//     *     Fullwidth digits
//     * </ul>
//     *
//     * Many other character ranges contain digits as well.
//     *
//     * @param   codePoint the character (Unicode code point) to be tested.
//     * @return  <code>true</code> if the character is a digit;
//     *          <code>false</code> otherwise.
//     * @see     java.lang.Character#forDigit(int, int)
//     * @see     java.lang.Character#getType(int)
//     * @since   1.5
//     */
//    public static boolean isDigit(int codePoint) {
//        boolean bDigit = false;
//
//        if (codePoint >= MIN_CODE_POINT && codePoint <= FAST_PATH_MAX) {
//            bDigit = CharacterDataLatin1.isDigit(codePoint);
//        } else {
//            int plane = getPlane(codePoint);
//            switch(plane) {
//            case(0):
//                bDigit = CharacterData00.isDigit(codePoint);
//                break;
//            case(1):
//                bDigit = CharacterData01.isDigit(codePoint);
//                break;
//            case(2):
//                bDigit = CharacterData02.isDigit(codePoint);
//                break;
//            case(3): // Undefined
//            case(4): // Undefined
//            case(5): // Undefined
//            case(6): // Undefined
//            case(7): // Undefined
//            case(8): // Undefined
//            case(9): // Undefined
//            case(10): // Undefined
//            case(11): // Undefined
//            case(12): // Undefined
//            case(13): // Undefined
//                bDigit = CharacterDataUndefined.isDigit(codePoint);
//                break;
//            case(14):
//                bDigit = CharacterData0E.isDigit(codePoint);
//                break;
//            case(15): // Private Use
//            case(16): // Private Use
//                bDigit = CharacterDataPrivateUse.isDigit(codePoint);
//                break;
//            default:
//                // the argument's plane is invalid, and thus is an invalid codepoint
//                // bDigit remains false;
//                break;
//            }
//        }
//        return bDigit;
//    }
//
//    /**
//     * Determines if a character is defined in Unicode.
//     * <p>
//     * A character is defined if at least one of the following is true:
//     * <ul>
//     * <li>It has an entry in the UnicodeData file.
//     * <li>It has a value in a range defined by the UnicodeData file.
//     * </ul>
//     *
//     * <p><b>Note:</b> This method cannot handle <a
//     * href="#supplementary"> supplementary characters</a>. To support
//     * all Unicode characters, including supplementary characters, use
//     * the {@link #isDefined(int)} method.
//     *
//     * @param   ch   the character to be tested
//     * @return  <code>true</code> if the character has a defined meaning
//     *          in Unicode; <code>false</code> otherwise.
//     * @see     java.lang.Character#isDigit(char)
//     * @see     java.lang.Character#isLetter(char)
//     * @see     java.lang.Character#isLetterOrDigit(char)
//     * @see     java.lang.Character#isLowerCase(char)
//     * @see     java.lang.Character#isTitleCase(char)
//     * @see     java.lang.Character#isUpperCase(char)
//     * @since   1.0.2
//     */
//    public static boolean isDefined(char ch) {
//        return isDefined((int)ch);
//    }
//
//    /**
//     * Determines if a character (Unicode code point) is defined in Unicode.
//     * <p>
//     * A character is defined if at least one of the following is true:
//     * <ul>
//     * <li>It has an entry in the UnicodeData file.
//     * <li>It has a value in a range defined by the UnicodeData file.
//     * </ul>
//     *
//     * @param   codePoint the character (Unicode code point) to be tested.
//     * @return  <code>true</code> if the character has a defined meaning
//     *          in Unicode; <code>false</code> otherwise.
//     * @see     java.lang.Character#isDigit(int)
//     * @see     java.lang.Character#isLetter(int)
//     * @see     java.lang.Character#isLetterOrDigit(int)
//     * @see     java.lang.Character#isLowerCase(int)
//     * @see     java.lang.Character#isTitleCase(int)
//     * @see     java.lang.Character#isUpperCase(int)
//     * @since   1.5
//     */
//    public static boolean isDefined(int codePoint) {
//        boolean bDefined = false;
//
//        if (codePoint >= MIN_CODE_POINT && codePoint <= FAST_PATH_MAX) {
//            bDefined = CharacterDataLatin1.isDefined(codePoint);
//        } else {
//            int plane = getPlane(codePoint);
//            switch(plane) {
//            case(0):
//                bDefined = CharacterData00.isDefined(codePoint);
//                break;
//            case(1):
//                bDefined = CharacterData01.isDefined(codePoint);
//                break;
//            case(2):
//                bDefined = CharacterData02.isDefined(codePoint);
//                break;
//            case(3): // Undefined
//            case(4): // Undefined
//            case(5): // Undefined
//            case(6): // Undefined
//            case(7): // Undefined
//            case(8): // Undefined
//            case(9): // Undefined
//            case(10): // Undefined
//            case(11): // Undefined
//            case(12): // Undefined
//            case(13): // Undefined
//                bDefined = CharacterDataUndefined.isDefined(codePoint);
//                break;
//            case(14):
//                bDefined = CharacterData0E.isDefined(codePoint);
//                break;
//            case(15): // Private Use
//            case(16): // Private Use
//                bDefined = CharacterDataPrivateUse.isDefined(codePoint);
//                break;
//            default:
//                // the argument's plane is invalid, and thus is an invalid codepoint
//                // bDefined remains false;
//                break;
//            }
//        }
//        return bDefined;
//    }
//
//    public static boolean isLetter(char ch) {
//        return isLetter((int)ch);
//    }
}
