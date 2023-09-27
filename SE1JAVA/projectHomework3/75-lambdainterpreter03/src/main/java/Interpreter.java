public class Interpreter {
    Parser parser;
    AST astAfterParser;

    public Interpreter(Parser p){
        parser = p;
        astAfterParser = p.parse();
        System.out.println("After parser:"+astAfterParser.toString());
    }

    private  boolean isAbstraction(AST ast){
        return ast instanceof Abstraction;
    }
    private  boolean isApplication(AST ast){
        return ast instanceof Application;
    }
    private  boolean isIdentifier(AST ast){
        return ast instanceof Identifier;
    }

    public AST eval(){
        return evalAST(astAfterParser);
    }


    private  AST evalAST(AST ast){ if (isIdentifier(ast)) {
        return ast;
    }

    else if (isAbstraction(ast)) {
        ((Abstraction) ast).body = evalAST(((Abstraction) ast).body);
        return ast;
    }

    else if (isApplication(ast)) {

        if (isIdentifier(((Application) ast).lhs)) {
        }

        else if (isAbstraction(((Application) ast).lhs)) {
            ((Application) ast).lhs = evalAST(((Application) ast).lhs);
        }

        else if (isApplication(((Application) ast).lhs)) {
            if (!(((Application) ((Application) ast).lhs).lhs instanceof Identifier && ((Application) ((Application) ast).lhs).rhs instanceof Identifier)) {
                ((Application) ast).lhs = evalAST(((Application) ast).lhs);
            }
        }


        if (((Application) ast).rhs != null) {
            if (isIdentifier(((Application) ast).rhs)) {
            }

            else if (isAbstraction(((Application) ast).rhs)) {
                (((Abstraction) ((Application) ast).rhs)).body = evalAST((((Abstraction) ((Application) ast).rhs)).body);
            }
            else if (isApplication(((Application) ast).rhs)) {
                if (!(((Application) ((Application) ast).rhs).lhs instanceof Identifier && ((Application) ((Application) ast).rhs).rhs instanceof Identifier)) {
                    ((Application) ast).rhs = evalAST(((Application) ast).rhs);
                }
            }
        }

        if (isIdentifier(((Application) ast).lhs)) {
            return ast;
        }

        else if (isAbstraction(((Application) ast).lhs)) {
            if(((Application) ast).rhs == null){
                return ((Application) ast).lhs;
            }
            else if (((Application) ast).rhs != null) {
                ast = substitute(((Abstraction) ((Application) ast).lhs).body, ((Application) ast).rhs);
                ast = evalAST(ast);//代换之后，还得化简！
                return ast;
            }
        }

        else if (isApplication(((Application) ast).lhs)) {
            return ast;
        }
    }
        return ast;

        //TODO
    }

    private AST substitute(AST node,AST value){
        return shift(-1,subst(node,shift(1,value,0),0),0);
    }

    private AST subst(AST node, AST value, int depth){
        if(isApplication(node)){
            return new Application(
                    subst(((Application)node).lhs, value, depth),
                    subst(((Application)node).rhs, value, depth)
            );
        }
        else if(isAbstraction(node)){
            return new Abstraction(
                    ((Abstraction)node).param,
                    subst(((Abstraction)node).body, value, depth+1)
            );
        }
        else if(isIdentifier(node)){
            if(Integer.parseInt(((Identifier)node).value) == depth){
                return shift(depth, value, 0);
            }
        }
        return node;//TODO
    }

    private AST shift(int by, AST node,int from){
        if(isApplication(node)){
        ((Application)node).lhs = shift(by, ((Application)node).lhs, from);
        ((Application)node).rhs = shift(by, ((Application)node).rhs, from);
    }
    else if(isAbstraction(node)){
        ((Abstraction)node).body = shift(by, ((Abstraction)node).body, from+1);
    }
    else if(isIdentifier(node)){
        int int_IdValue = Integer.parseInt(((Identifier)node).value);
        if(int_IdValue >= from){
            return new Identifier(((Identifier)node).name, ""+ (int_IdValue + by));
        }
    }
        return node;

        //TODO
    }
}