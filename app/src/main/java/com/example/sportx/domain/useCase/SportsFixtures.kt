package com.example.sportx.domain.useCase

import com.example.sportx.data.dto.fixture.cricket.CricketFixturesDto
import com.example.sportx.data.dto.fixture.tennis.TennisFixtureDto


sealed class SportsFixtures {
    class FootBall(val footBall : FixtureFootballAndBasketBallResponse) : SportsFixtures()
    class BasketBall(val basketBall : FixtureFootballAndBasketBallResponse ) : SportsFixtures()
    class Cricket(val cricket : CricketFixturesDto) : SportsFixtures()
    class Tennis (val tennis : TennisFixtureDto) : SportsFixtures()
}