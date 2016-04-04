package mum.eud.week1ExtraCredit.control;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import mum.eud.week1ExtraCredit.doa.MovieDAO;
import mum.eud.week1ExtraCredit.domain.Artist;
import mum.eud.week1ExtraCredit.domain.Director;
import mum.eud.week1ExtraCredit.domain.Genre;
import mum.eud.week1ExtraCredit.domain.Movie;
import mum.eud.week1ExtraCredit.domain.Rating;


/**
 * @author PatiRam
 *
 */
public class App {

	
	public static void main(String[] args) throws Exception {
		addNewMovie();
		opertionOnMovie();
	}
	private static void addNewMovie() throws Exception{
		Director director1 = new Director();
		director1.setName("Director A");
		Artist artist1 = new Artist();
		artist1.setName("Artist A");
		artist1.setDateOfBirth(new Date(1990-03-32));
		artist1.setDateOfPlace("Nepal");
		try{
			Path artistImagePath = FileSystems.getDefault().getPath("/resources/images/a.jpg");
			artist1.setProfilePicture(Files.readAllBytes(artistImagePath));
			artist1.setBiography("this is biography for artist 1");
		}catch(IOException e){
			System.out.println("Artist image error"+e.toString());
		}
		List<Artist> artistList1 = new ArrayList<>();
		List<Director> directors = new ArrayList<>();
		List<String> comments = new ArrayList<>();
		List<Genre> genres = new ArrayList<>();
		artistList1.add(artist1);
		directors.add(director1);
		Movie movie1 = new Movie();
		movie1.setTitle("Movie 1");
		movie1.setDescription("This is Movie 1 made in Nepal");
		movie1.setRating(Rating.GOOD);
		genres.add(Genre.ACTION);
		genres.add(Genre.COMEDY);
		movie1.setGenres(genres);
		comments.add("This is comment 1 for Movie 1");
		comments.add("This is comment 2 for Movie 2");
		movie1.setComments(comments);
		movie1.setArtists(artistList1);
		movie1.setDirectors(directors);
		MovieDAO movieDAO = new MovieDAO();
		movieDAO.createMovie(movie1);
	}
	public static void opertionOnMovie() throws Exception{
		MovieDAO dao = new MovieDAO();
		List<Movie> movies = dao.getMovieByName("Movie 1");
		for(Movie m : movies){
			System.out.println(m.getTitle());
		}
		movies.stream().map(Object::toString).forEach(System.out::println);
//		MovieDAO updateMovieDAO = new MovieDAO();
		Movie newInsert = new Movie();
		for(Movie m: movies){
			if(m.getTitle().equals("Movie 1")){
				newInsert = m;
//				newInsert.setTitle("Movie 2");
	//			dao.createMovie(newInsert);
				m.setTitle("Movie 1 Updated");
				dao.updateMovie(m);
			}
		}
		for(Movie m: movies){
			if(m.getTitle().equals("Movie 1 Updated")){
				dao.deleteMovie(m);
			}
		}
	}
}
