package ga.dryco.redditJerk.controllers;

import ga.dryco.redditJerk.Reddit;
import ga.dryco.redditJerk.RedditApi;
import ga.dryco.redditJerk.datamodels.T2Data;

import java.util.List;
import java.util.Objects;


public class User extends T2Data {

    Reddit rApi = RedditApi.getRedditInstance();

    public Overview getOverview(Integer limit, String sort)  {
        return rApi.getOverview(super.getName(), limit, sort);
    }

    public List<Link> getSubmitted(Integer limit)  {
       return rApi.getUserSubmissions(super.getName(), limit, "new");
    }

    public List<Link> getSubmitted(Integer limit, String sort)  {
        return rApi.getUserSubmissions(super.getName(), limit, sort);
    }

    public List<Comment> getComments(Integer limit)  {
        return rApi.getUserComments(super.getName(), limit, "new");
    }


    public List<Comment> getComments(Integer limit, String sort)  {
        return rApi.getUserComments(super.getName(), limit, sort);
    }


    /**
     * Extra utility functions
     */

    public Integer getKarmaBalance(String subreddit, Integer limit)  {
        Integer karma = 0;
        for(Comment comm: this.getComments(limit)){
            if(Objects.equals(comm.getSubreddit(), subreddit)){
                karma = karma + comm.getScore();
            }

        }

        for(Link subm:this.getSubmitted(limit)){
            if(Objects.equals(subm.getSubreddit(), subreddit)){
                karma = karma + subm.getScore();
            }
            }

        return karma;
    }



}
