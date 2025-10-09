package usecase;

import api.GradeDataBase;
import entity.Grade;
import entity.Team;

import java.util.ArrayList;
import java.util.Collections;

/**
 * GetMedianGradeUseCase class.
 */

public final class GetMedianGradeUseCase {
    private final GradeDataBase gradeDataBase;

    public GetMedianGradeUseCase(GradeDataBase gradeDataBase) {
        this.gradeDataBase = gradeDataBase;
    }
    /**
     * Get the average grade for a course across your team.
     * @param course The course.
     * @return The average grade.
     */
    public float getMedianGrade(String course) {
        // Call the API to get usernames of all your team members
        // Go to the MongoGradeDataBase class and implement getMyTeam.
        final Team team = gradeDataBase.getMyTeam();
        // Call the API to get all the grades for the course for all your team members
        String[] members = team.getMembers();
        ArrayList<Integer> Grades = new ArrayList<>();
        for (String member : members) {
            Grades.add(gradeDataBase.getGrade(member, course).getGrade());
        }
        // Complete the logic
        Collections.sort(Grades);

        int n = Grades.size();
        if (n == 0) {
            throw new IllegalArgumentException("List is empty!");
        }
        double mid;
        if (n % 2 == 1) {
            // 奇数个 → 取中间那个
            return Grades.get(n / 2);
        } else {
            // 偶数个 → 取中间两个的平均
            double mid1 = Grades.get(n / 2 - 1);
            double mid2 = Grades.get(n / 2);
            mid = (mid1 + mid2) / 2.0;
        }
        return (float) mid;
    }
}
