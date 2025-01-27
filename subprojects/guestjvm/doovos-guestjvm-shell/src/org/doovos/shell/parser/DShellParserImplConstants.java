/* Generated By:JavaCC: Do not edit this line. DShellParserImplConstants.java */
package org.doovos.shell.parser;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface DShellParserImplConstants {

    /**
     * End of File.
     */
    int EOF = 0;
    /**
     * RegularExpression Id.
     */
    int USING = 1;
    /**
     * RegularExpression Id.
     */
    int IF = 2;
    /**
     * RegularExpression Id.
     */
    int ELSE = 3;
    /**
     * RegularExpression Id.
     */
    int WHILE = 4;
    /**
     * RegularExpression Id.
     */
    int BREAK = 5;
    /**
     * RegularExpression Id.
     */
    int GOTO = 6;
    /**
     * RegularExpression Id.
     */
    int LABEL = 7;
    /**
     * RegularExpression Id.
     */
    int OP_EQ = 8;
    /**
     * RegularExpression Id.
     */
    int OP_COMMA = 9;
    /**
     * RegularExpression Id.
     */
    int OP_AND = 10;
    /**
     * RegularExpression Id.
     */
    int OP_AND2 = 11;
    /**
     * RegularExpression Id.
     */
    int OP_THEN = 12;
    /**
     * RegularExpression Id.
     */
    int OP_AT = 13;
    /**
     * RegularExpression Id.
     */
    int OP_AT2 = 14;
    /**
     * RegularExpression Id.
     */
    int OP_VDASH = 15;
    /**
     * RegularExpression Id.
     */
    int OP_VDASH2 = 16;
    /**
     * RegularExpression Id.
     */
    int OP_LT = 17;
    /**
     * RegularExpression Id.
     */
    int OP_LT2 = 18;
    /**
     * RegularExpression Id.
     */
    int OP_LET = 19;
    /**
     * RegularExpression Id.
     */
    int OP_GT = 20;
    /**
     * RegularExpression Id.
     */
    int OP_GT2 = 21;
    /**
     * RegularExpression Id.
     */
    int OP_GET = 22;
    /**
     * RegularExpression Id.
     */
    int LACC = 23;
    /**
     * RegularExpression Id.
     */
    int RACC = 24;
    /**
     * RegularExpression Id.
     */
    int LPAR = 25;
    /**
     * RegularExpression Id.
     */
    int RPAR = 26;
    /**
     * RegularExpression Id.
     */
    int RED_IN = 27;
    /**
     * RegularExpression Id.
     */
    int RED_OUT_APP = 28;
    /**
     * RegularExpression Id.
     */
    int RED_ERR_APP = 29;
    /**
     * RegularExpression Id.
     */
    int RED_OUT = 30;
    /**
     * RegularExpression Id.
     */
    int RED_ERR = 31;
    /**
     * RegularExpression Id.
     */
    int NEWLINE = 32;
    /**
     * RegularExpression Id.
     */
    int ITEM_STRING_DBL = 33;
    /**
     * RegularExpression Id.
     */
    int ITEM_STRING_SMP = 34;
    /**
     * RegularExpression Id.
     */
    int ITEM_STRING_ANTI = 35;
    /**
     * RegularExpression Id.
     */
    int ITEM_VAR = 36;
    /**
     * RegularExpression Id.
     */
    int ITEM_NAME = 37;

    /**
     * Lexical state.
     */
    int DEFAULT = 0;

    /**
     * Literal token values.
     */
    String[] tokenImage = {
            "<EOF>",
            "\"using\"",
            "\"if\"",
            "\"else\"",
            "\"while\"",
            "\"break\"",
            "\"goto\"",
            "\"label\"",
            "\"=\"",
            "\";\"",
            "\"&\"",
            "\"&&\"",
            "\"==>\"",
            "\"@\"",
            "\"@@\"",
            "\"|\"",
            "\"||\"",
            "\"<\"",
            "\"<<\"",
            "\"<=\"",
            "\">\"",
            "\">>\"",
            "\">=\"",
            "\"{\"",
            "\"}\"",
            "\"(\"",
            "\")\"",
            "\"&<\"",
            "<RED_OUT_APP>",
            "\"&2>>\"",
            "<RED_OUT>",
            "\"&2>\"",
            "\"\\n\"",
            "<ITEM_STRING_DBL>",
            "<ITEM_STRING_SMP>",
            "<ITEM_STRING_ANTI>",
            "<ITEM_VAR>",
            "<ITEM_NAME>",
            "\" \"",
            "\"\\t\"",
            "<token of kind 40>",
            "<token of kind 41>",
            "<token of kind 42>",
    };

}
