import static org.junit.Assert.*;
import org.junit.Test;


public class TestPostfixEvaluation {

	@Test
	public void testPostfixEvaluation() {
		InfixToPostfix stack = new InfixToPostfix();
		PostfixEvaluation postfixEvaluation = new PostfixEvaluation();
		
		String input = "1+2*(2^5-4)-9";
		String result = stack.infixToPostfix(input);
		int output1 = PostfixEvaluation.evaluatePostfix(result);
		int expectedData = 48;
		assertEquals(expectedData, output1);
		
		input = "1+2*(2^5-4)";
		result = stack.infixToPostfix(input);
		@SuppressWarnings("static-access")
		int output2 = postfixEvaluation.evaluatePostfix(result);
		expectedData = 57;
		assertEquals(expectedData, output2);
	}
}
