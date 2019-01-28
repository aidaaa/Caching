package eu.example.aida.caching.data.mapper;

import java.util.ArrayList;
import java.util.List;

import eu.example.aida.caching.data.model.MoviesData;
import eu.example.aida.caching.domain.model.DomainMetaData;
import eu.example.aida.caching.domain.model.Movie;
import eu.example.aida.caching.domain.model.MoviesDomain;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by Aida on 1/20/2019.
 */

public class Mapper implements Function<MoviesData,MoviesDomain>
{

    public MoviesDomain transfer(MoviesData data)
    {
        if (data == null)
        {
            throw new IllegalArgumentException("Error");
        }
        MoviesDomain domain=new MoviesDomain();

        DomainMetaData domainMetaData=new DomainMetaData();
        domainMetaData.setCurrent_page(data.metadata.getCurrent_page());
        domainMetaData.setPer_page(data.metadata.getPer_page());
        domainMetaData.setPage_count(data.metadata.getPage_count());
        domainMetaData.setTotal_count(data.metadata.getTotal_count());

        domain.metadata=domainMetaData;

        for (int i = 0; i < data.data.size(); i++)
        {
            Movie movieDomain = new Movie();
            movieDomain.setId(data.data.get(i).getId());
            movieDomain.setTitle(data.data.get(i).getTitle());
            movieDomain.setPoster(data.data.get(i).getPoster());
            movieDomain.setYear(data.data.get(i).getYear());
            movieDomain.setImdb_rating(data.data.get(i).getImdb_rating());

            domain.data.add(i,movieDomain);
        }
        return domain;
    }

    public List<MoviesDomain> transfer(List<MoviesData> data)
    {
        List<MoviesDomain> list=new ArrayList<>();
        for (MoviesData moviesData : data)
        {
            MoviesDomain domain = transfer(moviesData);
            if (domain!=null)
            {
                list.add(domain);
            }
        }
        return list;
    }

    @Override
    public MoviesDomain apply(@NonNull MoviesData moviesData) throws Exception
    {
        return transfer(moviesData);
    }
}
