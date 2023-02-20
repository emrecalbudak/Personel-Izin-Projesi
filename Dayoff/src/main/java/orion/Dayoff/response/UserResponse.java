package orion.Dayoff.response;

import lombok.Data;
import orion.Dayoff.entity.User;

@Data
public class UserResponse {

	private Long id;
	private String userName;
	public UserResponse(User entity) {
		this.id = entity.getId();
		this.userName = entity.getUserName();
	}
}
