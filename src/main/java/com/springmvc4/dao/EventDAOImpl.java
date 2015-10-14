package com.springmvc4.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.springmvc4.model.Attendee;
import com.springmvc4.model.Event;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.Statement;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.GeneratedKeyHolder;

public class EventDAOImpl implements EventDAO {

	private JdbcTemplate jdbcTemplate;

	public EventDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Event createNew() {
		Event event = new Event();
		event.setName("Default event");
		event.setId((long)-1);
		return event;
	}

	@Transactional
	@Override
	public void saveEvent(Event event) {
		if (event.getId() > 0) { // update
			String sql = "UPDATE event SET name=?, date=?, location=?, "
					+ "duration=?, url=? WHERE event_id=?";
			jdbcTemplate.update(sql, event.getName(), event.getDate(),
					event.getLocation(), event.getDuration(), event.getUrl(),
					event.getId());
		}
	}

	@Transactional
	@Override
	public long createEvent(final Event event) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		final PreparedStatementCreator psc = new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(
					final Connection connection) throws SQLException {
				final PreparedStatement ps = connection
						.prepareStatement(
								"INSERT INTO event(name, date, location, duration, url) VALUES (?, ?, ?, ?, ?)",
								Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, event.getName());
				ps.setDate(2, new java.sql.Date(event.getDate().getTime()));
				ps.setString(3, event.getLocation());
				ps.setInt(4, event.getDuration());
				ps.setString(5, event.getUrl());
				return ps;
			}
		};
		jdbcTemplate.update(psc, keyHolder);
		return keyHolder.getKey().longValue();

	}

	@Transactional
	@Override
	public void deleteEvent(long eventId) {
		if (eventId > 0) {
			// update
			String sql = "DELETE from event WHERE event_id=?";
			jdbcTemplate.update(sql, eventId);
		}
	}

	@Transactional
	@Override
	public Event findOne(long eventId) {
		String sql = "SELECT * FROM event WHERE event_id=" + eventId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Event>() {

			@Override
			public Event extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Event anEvent = new Event();
					anEvent.setId(rs.getLong("event_id"));
					anEvent.setName(rs.getString("name"));
					anEvent.setDate(rs.getDate("date"));
					anEvent.setLocation(rs.getString("location"));
					anEvent.setDuration(rs.getInt("duration"));
					anEvent.setUrl(rs.getString("url"));
					return anEvent;
				}
				return null;
			}
		});
	}

	@Transactional
	@Override
	public Event getOne(long eventId) {
		Event event = findOne(eventId);
		List<Attendee> attendees = getAttendees(eventId);
		event.setAttendees(attendees);
		return event;
	}

	@Transactional
	@Override
	public List<Event> getAll() {
		String sql = "SELECT * FROM event";
		List<Event> listEvent = jdbcTemplate.query(sql, new RowMapper<Event>() {

			@Override
			public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
				Event anEvent = new Event();
				anEvent.setId(rs.getLong("event_id"));
				anEvent.setName(rs.getString("name"));
				anEvent.setDate(rs.getDate("date"));
				anEvent.setLocation(rs.getString("location"));
				anEvent.setDuration(rs.getInt("duration"));
				anEvent.setUrl(rs.getString("url"));
				//List<Attendee> attendees = getAttendees(anEvent.getId());
				//anEvent.setAttendees(attendees);
				return anEvent;
			}
		});
		return listEvent;
	}

	@Transactional
	@Override
	public List<Attendee> getAttendees(long eventId) {
		String sql = "SELECT * FROM attendee WHERE event_id=" + eventId;
		List<Attendee> attendees = jdbcTemplate.query(sql,
				new RowMapper<Attendee>() {
					@Override
					public Attendee mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Attendee anAttendee = new Attendee();
						anAttendee.setId(rs.getLong("attendee_id"));
						anAttendee.setName(rs.getString("name"));
						anAttendee.setEmail(rs.getString("email"));
						anAttendee.setPhone(rs.getString("phone"));
						anAttendee.setCompany(rs.getString("company"));
						anAttendee.setGender(rs.getString("gender"));
						return anAttendee;
					}
				});
		return attendees;
	}

}
