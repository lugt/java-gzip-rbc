public class RBCTest {

  public String readUserInput() {
    ///... read some thing that is user controllable
    return "this value only serves to be a place-holder";
  }

  public void conductRiskyOperation(String input) {
    // ... do something risky
  }

  public void test() {
    String val = readUserInput();
    conductRiskyOperation(val);
  }
}
