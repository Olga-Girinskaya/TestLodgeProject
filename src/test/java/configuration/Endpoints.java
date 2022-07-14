package configuration;

public class Endpoints {

    public static final String ADD_USER = "/index.php?/api/v2/add_user";
    public static final String UPDATE_USER = "/index.php?/api/v2/update_user";
    public static final String GET_USER = "/index.php?/api/v2/get_user/{user_id}";
    public static final String GET_USER_BY_EMAIL = "/index.php?/api/v2/get_user_by_email&email={email}";


}
