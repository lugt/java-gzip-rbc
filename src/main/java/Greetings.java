import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class Greetings {
  java.sql.Statement stmt = null;
  HttpServletRequest req = null;

  public void unsafeExecute(String value, int condition) throws SQLException {
    String sql = "SELECT * from abc";
    if (condition < 2) {
      sql = " SELECt * from abc where password = '" + value + "'";
      stmt.execute(sql);
    } else {
      stmt.execute(sql);
    }
  }

  public void safeExecute(String value, int condition) throws SQLException {
    String sql = "SELECT * from abc " + Integer.parseInt(value);
    stmt.execute(sql);
  }

  private String getValueMaybeTainted(int condition) throws IOException {
    byte[] bytes = new byte[1000];
    if (condition == 1) {
      return req.getParameter("abc");
    } else {
      return "normal";
    }
  }

  public void test() throws SQLException, IOException {
    int condition = (int) (Math.random() * 3);
    String valueMaybeTainted = getValueMaybeTainted(condition);
    unsafeExecute(valueMaybeTainted, condition);
    safeExecute(valueMaybeTainted, condition);
  }
}
