import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectSample {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//データベース接続情報を格納する変数
		Connection conn = null;

		//		JDBCドライバの読み込み
		try {
			//postgresSQLのJDBCドライバを読み込み
			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			//データベースへの接続
			conn = DriverManager.getConnection(
					"jdbc:postgresql:company", //データベース名
					"postgres", //ユーザー名
					"hfuser"//パスワード
			);

			//SELECT文の発行と結果の取得
			//Statementオブジェクトを生成
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM users";
			ResultSet rset = stmt.executeQuery(sql);

			//結果の表示
			while (rset.next()) {
				System.out.println(rset.getString("name"));
			}

		} catch (SQLException e) {
			//接続、SELECT文でエラーが発生した場合
			e.printStackTrace();
		} finally {
			//データベース接続の切断
			if (conn != null) {
				try {
					conn.close();
					conn = null;
				} catch (SQLException e) {
					//データベースの切断でエラーが発生した場合
					e.printStackTrace();
				}
			}

		}

	}

}
