package orion.Dayoff.request;

import lombok.Data;

@Data
public class UserRequest {
	String userName;
	String password;
	String accessToken;
}
