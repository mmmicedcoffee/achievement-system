package achievement;

import achievement.awards.*;

import java.util.HashSet;

import static com.google.common.collect.Sets.newHashSet;

public class AchievementSetFactory {
    public HashSet<Achievement> createFullAchievementSet() {
        final HashSet<Achievement> achievements = newHashSet();
        achievements.add(new BigWinnerAward());
        achievements.add(new BruiserAward());
        achievements.add(new SharpshooterAward());
        achievements.add(new VeteranAward());
        achievements.add(new HomesickAward());

        return achievements;
    }
}
