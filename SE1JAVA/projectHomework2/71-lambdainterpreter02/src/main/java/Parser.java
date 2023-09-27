import java.util.ArrayList;

public class Parser {
    Lexer lexer;
    public Parser(Lexer l){
        lexer = l;
    }

    public AST parse(){//解析入口
        AST ast = parseAsTerm(new ArrayList<>());
        return ast;
    }

    /**
     *解析 term
     * @param ctx
     * @return
     */
    private AST parseAsTerm(ArrayList<String> ctx){
        String param;
        String param1;
        if (lexer.skipThisType(TokenType.LAMBDA)){
            if (lexer.nextIsMatched(TokenType.LCID)){
                param = lexer.tokenvalue;
                lexer.checkAndNext(TokenType.LCID);
                if (lexer.skipThisType(TokenType.DOT)) {

                    ctx.add(0, param);
                    param1 = "" + ctx.indexOf(param);
                    AST aTerm = parseAsTerm(ctx);
                    ctx.remove(param);
                    return new Abstraction(new Identifier(param, param1), aTerm);
                }
            }
            else
                System.out.println("Wrong Input");
        } else {
            return parseAsApplication(ctx);
        }
        //TODO
        return null;
    }

    /**
     *解析 application
     * @param ctx
     * @return
     */
    private AST parseAsApplication(ArrayList<String> ctx){
        AST left = parseAsAtom(ctx);
        AST right;
        while (true) {
            right = parseAsAtom(ctx);
            if (right == null)
                return left;
            else
                left = new Application(left, right);
        }
        //TODO
    }

    /**
     *解析 atom
     * @param ctx
     * @return
     */
    private AST parseAsAtom(ArrayList<String> ctx){
        String param;
        String paramValue;
        if (lexer.skipThisType(TokenType.LPAREN)){
            AST aTerm = parseAsTerm(ctx);
            if (lexer.skipThisType(TokenType.RPAREN))
                return aTerm;
        } else if (lexer.nextIsMatched(TokenType.LCID)) {
            param = lexer.tokenvalue;
            paramValue = "" + ctx.indexOf(param);
            lexer.checkAndNext(TokenType.LCID);
            return new Identifier(param, paramValue);
        }
        //TODO
        return  null;
    }
}
