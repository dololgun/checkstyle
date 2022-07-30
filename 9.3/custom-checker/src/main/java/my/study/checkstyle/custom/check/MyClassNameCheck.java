package my.study.checkstyle.custom.check;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;
import com.puppycrawl.tools.checkstyle.utils.CommonUtil;

public class MyClassNameCheck extends AbstractCheck {

    private final Set<String> standardWords = new HashSet<>();

    public MyClassNameCheck() {

        standardWords.add("infm"); // 정보
        standardWords.add("user"); // 유저
        standardWords.add("dept"); // 부서
        standardWords.add("mngm"); // 관리

    }

    @Override
    public int[] getDefaultTokens() {
        return getAcceptableTokens();
    }

    @Override
    public int[] getAcceptableTokens() {
        return new int[] { TokenTypes.INTERFACE_DEF, TokenTypes.CLASS_DEF };
    }

    @Override
    public int[] getRequiredTokens() {
        return CommonUtil.EMPTY_INT_ARRAY;
    }

    @Override
    public void visitToken(DetailAST ast) {
        
        System.out.println("ddd");

        DetailAST findFirstToken = ast.findFirstToken(TokenTypes.IDENT);
        String name = findFirstToken.getText();

        String[] tokens = StringUtils.splitByCharacterTypeCamelCase(name);

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i].toLowerCase();
            if (!standardWords.contains(token)) {
                log(ast, "잘못된 이름사용");
            }
        }
    }
}
