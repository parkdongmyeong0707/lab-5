package example;

import java.io.IOException;

/**
 * Class for getting your Grade API token.
 */
public class GetToken {

    /**
     * Run to get your token after you complete the code.
     * @param args unused arguments
     */
    public static void main(String[] args) throws IOException {
        GetExample example = new GetExample();

        String gradeAPISignUpURL = "https://grade-apis.panchen.ca/";
        // Task 1: use the run method to get your Grade API token (or obtain your token through a web browser).
        String response = example.run("https://grade-apis.panchen.ca/signUp?username=Baihan");
        System.out.println(response);
    }
}
