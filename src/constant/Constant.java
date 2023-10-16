package constant;

public class Constant {
    public static class ConstantCard {
        public static final String TABLE_NAME = "card";
        public static final String USERNAME = "username";
        public static final String PASS_WORD = "passWord";
        public static final String BALANCE = "balance";
        public static final String INSERT_CARD = "INSERT INTO %s(%s, %s, %s)VALUES (?, ?, ?)";
        public static final String UPDATE_CARD = "UPDATE %s SET %s = ?, %s = ? WHERE %s = ?";
        public static final String DELETE_CARD = "DELETE FROM %s WHERE %s = ?";
        public static final String SELECT_CARD = "SELECT * FROM %s";
        public static final String SELECT_BY_ID = "SELECT * FROM %s WHERE %s = ?";
    }

    public static class ConstantUser {
        public static final String TABLE_NAME = "user";
        public static final String USERNAME = "username";
        public static final String FULL_NAME = "fullName";
        public static final String AGE = "age";
        public static final String SEX = "sex";
        public static final String ADDRESS = "address";
        public static final String CHECK_EXISTENCE = "SELECT COUNT(*) AS username FROM card WHERE username = ? LIMIT 1";
        public static final String INSERT_USER = "INSERT INTO %s(%s, %s, %s, %s, %s)VALUES (?, ?, ?, ?, ?)";
        public static final String UPDATE_USER = "UPDATE %s SET %s = ?, %s = ?, %s = ?, %s = ? WHERE %s = ?";
        public static final String DELETE_USER = "DELETE FROM %s WHERE %s = ?";
        public static final String SELECT_USER = "SELECT * FROM %s";
        public static final String SELECT_BY_ID = "SELECT * FROM %s WHERE %s = ?";
    }
}
