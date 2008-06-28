package edu.wustl.common.querysuite.queryobject;

import edu.wustl.common.querysuite.queryobject.impl.BaseQueryObject;

public class OutputTerm extends BaseQueryObject implements IOutputTerm {
    private static final long serialVersionUID = 5063978137285352552L;

    private String name;

    private ITerm term;

    public OutputTerm() {
        System.out.println("");
    }

    public OutputTerm(String name, ITerm term) {
        this.name = name;
        this.term = term;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ITerm getTerm() {
        return term;
    }

    public void setTerm(ITerm term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "term : " + term + "; name : " + name;
    }
}