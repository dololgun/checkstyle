package app.my.checks;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import net.sf.saxon.expr.FirstItemExpression;

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
		
		DetailAST dotToken = ast.findFirstToken(TokenTypes.DOT);
		if (dotToken  != null) {
			
			String packageName = getNameFromDotToken(dotToken);
			
			if (packageName == null || !packageName.startsWith("app.my")) {
				log(dotToken, "package name must be started app.my!! package name=" + packageName);
			}
		}
	}
	
	private String getNameFromDotToken(DetailAST dotToken) {
		
		DetailAST first = dotToken.getFirstChild();
		DetailAST second = first.getNextSibling();
		
		String firstName = null;
		String secondName = null;
		if (first.getType() == TokenTypes.DOT) {
			firstName = getNameFromDotToken(first);
		} else {
			firstName = first.getText();
		}
		
		if (second.getType() == TokenTypes.DOT) {
			secondName = getNameFromDotToken(second);
		} else {
			secondName = second.getText();
		}
		
		return firstName + "." + secondName;
	}
}
