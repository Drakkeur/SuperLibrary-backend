package edu.m2i.api_gestion_bibliotheque.entity;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "Loan")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false)
	private Integer id;
	@Column(nullable = false)
	private LocalDate dateStart;
	@Column(nullable = false)
	private LocalDate theoreticalDateEnd;
	private LocalDate realDateEnd;
	@Column(nullable = false)
	private Integer status;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "id_work", nullable = false)
	@JsonIgnoreProperties
	private Work work;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "id_user", nullable = false)
	@JsonIgnoreProperties
	private User user;

	public Loan() {
		super();
	}

	public Loan(LocalDate dateStart, LocalDate theoreticalDateEnd, Integer status, Work work, User user) {
		super();
		this.dateStart = dateStart;
		this.theoreticalDateEnd = theoreticalDateEnd;
		this.status = status;
		this.work = work;
		this.user = user;
	}

	public LocalDate getDateStart() {
		return dateStart;
	}

	public void setDateStart() {
		this.dateStart = LocalDate.now();
	}

	public LocalDate getTheoreticalDateEnd() {
		return theoreticalDateEnd;
	}

	public void setTheoreticalDateEnd() {
		this.theoreticalDateEnd = this.dateStart.plusWeeks(2);
	}

	public LocalDate getRealDateEnd() {
		return realDateEnd;
	}

	public void setRealDateEnd(LocalDate realDateEnd) {
		this.realDateEnd = realDateEnd;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Work getWork() {
		return work;
	}

	public void setWork(Work work) {
		this.work = work;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateStart, id, work, realDateEnd, status, theoreticalDateEnd, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan other = (Loan) obj;
		return Objects.equals(dateStart, other.dateStart) && Objects.equals(id, other.id)
				&& Objects.equals(work, other.work) && Objects.equals(realDateEnd, other.realDateEnd)
				&& Objects.equals(status, other.status) && Objects.equals(theoreticalDateEnd, other.theoreticalDateEnd)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Loan [id=" + id + ", dateStart=" + dateStart + ", theoreticalDateEnd=" + theoreticalDateEnd
				+ ", realDateEnd=" + realDateEnd + ", status=" + status + ", work=" + work + ", user=" + user + "]";
	}

}
