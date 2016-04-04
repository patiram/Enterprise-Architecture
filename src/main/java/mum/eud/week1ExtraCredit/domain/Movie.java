package mum.eud.week1ExtraCredit.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cascade;

/**
 * @author PatiRam
 *
 */
@Entity
public class Movie {
	@Id
	@GeneratedValue
	private long id;
	private String title;
	private String description;
	@ManyToMany
	@JoinTable
	@Cascade(value = {org.hibernate.annotations.CascadeType.ALL })
	private List<Director> directors = new ArrayList<>();
	@ManyToMany
	@JoinTable
	@Cascade(value = {org.hibernate.annotations.CascadeType.ALL })
	private List<Artist> artists = new ArrayList<>();
	@ElementCollection
	@Enumerated(EnumType.STRING)
	private List<Genre> genres = new ArrayList<>();
	@ElementCollection
	private List<String> comments = new ArrayList<>();
	@Enumerated(EnumType.STRING)
	private Rating rating;
	@Lob
	private byte[] moviePoster;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Director> getDirectors() {
		return directors;
	}
	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}
	public List<Artist> getArtists() {
		return artists;
	}
	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}
	public List<Genre> getGenres() {
		return genres;
	}
	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}
	public List<String> getComments() {
		return comments;
	}
	public void setComments(List<String> comments) {
		this.comments = comments;
	}
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	public byte[] getMoviePoster() {
		return moviePoster;
	}
	public void setMoviePoster(byte[] moviePoster) {
		this.moviePoster = moviePoster;
	}
	
}
