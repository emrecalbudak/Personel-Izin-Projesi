package orion.Dayoff.response;

import lombok.Data;

@Data
public class AuthResponse {
	String message;
	Long userId;
	String accessToken;
}
