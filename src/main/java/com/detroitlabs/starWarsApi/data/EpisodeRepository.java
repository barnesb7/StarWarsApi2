package com.detroitlabs.starWarsApi.data;

import com.detroitlabs.starWarsApi.model.EpisodeData;

public class EpisodeRepository {
    private EpisodeData episodeData;

    public EpisodeData getEpisodeData() {
        return episodeData;
    }

    public void setEpisodeData(EpisodeData episodeData) {
        this.episodeData = episodeData;
    }
}
