package app.my.checks;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

public class MyPackageNameCheck extends AbstractCheck {

	@Override
	public int[] getDefaultTokens() {
		System.out.println("Hello World! : getDefaultTokens");
		return new int[] { TokenTypes.PACKAGE_DEF };  
	}

	@Override
	public int[] getAcceptableTokens() {
		System.out.println("Hello World! : getAcceptableTokens");
		return null;
	}

	@Override
	public int[] getRequiredTokens() {
		System.out.println("Hello World! : getRequiredTokens");
		return null;  
	}

	@Override
	public void visitToken(DetailAST ast) {
		log(ast, "hello world!");
		System.out.println("hello world! : " + ast);
	}
}
