package com.springmvc4.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.springmvc4.model.Attendee;
import com.springmvc4.model.Event;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

public class AttendeeDAOImpl implements AttendeeDAO {

	private JdbcTemplate jdbcTemplate;

	public AttendeeDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Transactional
	@Override
	public void addToEvent(Attendee attendee, Event event) {
		createAttendee(attendee);
		event.getAttendees().add(attendee);
	}
	
	@Override
	public Attendee createNew() {
		Attendee attendee = new Attendee();
		attendee.setName("Default event");
		attendee.setId((long)-1);
		attendee.setEventId((long)-1);
		return attendee;
	}

	@Transactional
	@Override
	public void saveAttendee(Attendee attendee) {
		if (attendee.getAttendeeId() > 0) {
			// update
			String sql = "UPDATE attendee SET name=?, gender=?, company=?, email=?, "
					+ "phone=?, fk_event_id=? WHERE attendee_id=?";
			jdbcTemplate.update(sql, attendee.getName(), attendee.getGender(),
					attendee.getCompany(), attendee.getEmail(),
					attendee.getPhone(), attendee.getEventId(),
					attendee.getAttendeeId());
		}
	}

	@Transactional
	@Override
	public void createAttendee(Attendee attendee) {
		// insert
		String sql = "INSERT into attendee(attendee_id,name, gender, email, phone, fk_event_id, company) VALUES "
				+ "(?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, 0, attendee.getName(), attendee.getGender(),
				attendee.getEmail(), attendee.getPhone(), attendee.getEventId(), attendee.getCompany());
	}

	@Transactional
	@Override
	public Attendee get(int attendeeId) {
		String sql = "SELECT * FROM attendee WHERE attendee_id=" + attendeeId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Attendee>() {

			@Override
			public Attendee extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Attendee anAttendee = new Attendee();
					anAttendee.setId(rs.getLong("attendee_id"));
					anAttendee.setName(rs.getString("name"));
					anAttendee.setEmail(rs.getString("email"));
					anAttendee.setPhone(rs.getString("phone"));
					anAttendee.setEventId(rs.getLong("fk_event_id"));
					anAttendee.setCompany(rs.getString("company"));
					return anAttendee;
				}
				return null;
			}
		});
	}

	@Transactional
	@Override
	public List<Attendee> list() {
		String sql = "SELECT * FROM attendee";
		List<Attendee> listAttendee = jdbcTemplate.query(sql,
				new RowMapper<Attendee>() {

					@Override
					public Attendee mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Attendee anAttendee = new Attendee();
						anAttendee.setId(rs.getLong("attendee_id"));
						anAttendee.setName(rs.getString("name"));
						anAttendee.setEmail(rs.getString("email"));
						anAttendee.setPhone(rs.getString("phone"));
						anAttendee.setEventId(rs.getLong("fk_event_id"));
						anAttendee.setCompany(rs.getString("company"));
						return anAttendee;
					}
				});
		return listAttendee;
	}

}
