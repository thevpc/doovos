/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.doovos.kernel.vanilla.jvm.interpreter.jjit.unbrekable;

/**
 *
 * @author vpc
 */
public class BlocIF extends Bloc{
    Bloc condition;
    Bloc trueBloc;
    Bloc falseBloc;

    @Override
    public String toString() {
        return "BlocIF("+condition+")";
    }

    public Bloc getCondition() {
        return condition;
    }

    public Bloc getTrueBloc() {
        return trueBloc;
    }

    public Bloc getFalseBloc() {
        return falseBloc;
    }
}
