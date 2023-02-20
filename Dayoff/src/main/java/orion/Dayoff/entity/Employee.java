package orion.Dayoff.entity;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="employee")
@AllArgsConstructor
@NoArgsConstructor
public class Employee{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="address")
	private String address;
	@Column(name="email_address")
	private String mailAddress;
	@Column(name="start_date")
	private Date startDate;
	@Column(name="identity_no")
	private String identityNo;
}
