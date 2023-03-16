public class TennisGame {

    public static final String LOVE_ALL = "Love-All";
    public static final String FIFTEEN_ALL = "Fifteen-All";
    public static final String THIRTY_ALL = "Thirty-All";
    public static final String FORTY_ALL = "Forty-All";
    public static final String DEUCE = "Deuce";

    public static String getScore(String player1Name, String player2Name, int m_score1, int m_score2) {
        StringBuilder score = new StringBuilder();
        int tempScore=0;
        boolean equal = m_score1 == m_score2;
        if (equal)
        {
            score = getStringBuilder(m_score1);
        }
        else if (m_score1>=4 || m_score2>=4)
        {
            score = getStringBuilder(m_score1, m_score2);
        }
        else
        {
            extracted(m_score1, m_score2, score);
        }
        return score.toString();
    }

    private static StringBuilder getStringBuilder(int m_score1, int m_score2) {
        StringBuilder score;
        int minusResult = m_score1 - m_score2;
        if (minusResult==1) score = new StringBuilder("Advantage player1");
        else if (minusResult ==-1) score = new StringBuilder("Advantage player2");
        else if (minusResult>=2) score = new StringBuilder("Win for player1");
        else score = new StringBuilder("Win for player2");
        return score;
    }

    private static StringBuilder getStringBuilder(int m_score1) {
        StringBuilder score;
        switch (m_score1)
        {
            case 0:
                score = new StringBuilder(LOVE_ALL);
                break;
            case 1:
                score = new StringBuilder(FIFTEEN_ALL);
                break;
            case 2:
                score = new StringBuilder(THIRTY_ALL);
                break;
            case 3:
                score = new StringBuilder(FORTY_ALL);
                break;
            default:
                score = new StringBuilder(DEUCE);
                break;
        }
        return score;
    }

    private static void extracted(int m_score1, int m_score2, StringBuilder score) {
        int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = m_score1;
            else { score.append("-"); tempScore = m_score2;}
            switch(tempScore)
            {
                case 0:
                    score.append("Love");
                    break;
                case 1:
                    score.append("Fifteen");
                    break;
                case 2:
                    score.append("Thirty");
                    break;
                case 3:
                    score.append("Forty");
                    break;
            }
        }
    }
}
