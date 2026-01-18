package org.example;

public class FunEnvironment {

    private String name;
    private ParamNodeDecl paramNodeDecl;
    private Fun envF;

    public FunEnvironment(String name, ParamNodeDecl paramNodeDecl, Fun f)
    {
        this.name = name;
        this.paramNodeDecl = paramNodeDecl;
        this.envF = f;
    }

    public String getName() {
        return name;
    }

    public ParamNodeDecl getParamNodeDecl() {
        return paramNodeDecl;
    }




}
