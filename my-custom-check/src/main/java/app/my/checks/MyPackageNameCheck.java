package app.my.checks;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

public class MyPackageNameCheck extends AbstractCheck {

	@Override
	public int[] getDefaultTokens() {
		System.out.println("my checkstyle ~~1");
		return new int[] { TokenTypes.PACKAGE_DEF };  
	}

	@Override
	public int[] getAcceptableTokens() {
		return null;
	}

	@Override
	public int[] getRequiredTokens() {
		return null;  
	}

	@Override
	public void visitToken(DetailAST ast) {
		DetailAST dotToken = ast.findFirstToken(TokenTypes.DOT);
		if (dotToken  != null) {
			System.out.println("I found token : " + dotToken);			
			log(dotToken, "my error");
		}
	}
	
	

}
