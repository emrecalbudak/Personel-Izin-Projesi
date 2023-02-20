package orion.Dayoff.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="dayoff")
@AllArgsConstructor
@NoArgsConstructor
public class DayOff{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="start_date")
	private Date startDate;
	@Column(name="end_date")
	private Date endDate;
	@Column(name="remaining")
	private int remaining;
	
	@OneToOne()
	@JoinColumn(name="employee_id")
	private Employee employee;
	
}
