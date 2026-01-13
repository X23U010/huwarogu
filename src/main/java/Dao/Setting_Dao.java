package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Member;

public class Setting_Dao extends Base_Dao {

    // パスワード更新用
    public boolean Member_Update(Member member) {
        boolean isUpdate = false;
        try {
            this.connect();
            String sql = "UPDATE member_table SET member_password = ? WHERE member_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, member.getMember_password());
            ps.setString(2, member.getMember_id());
            int record = ps.executeUpdate();
            if (record > 0) isUpdate = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { this.disConnect(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return isUpdate;
    }

    // 教師リスト取得用
    public ArrayList<Member> Teacher_findAll() {
        ArrayList<Member> teacher_list = new ArrayList<Member>();
        Statement stmt = null;
        try {
            this.connect();
            String sql = "SELECT * FROM member_table"; 
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String str = rs.getString("member_id");
                if(str != null && str.startsWith("t")) { // 先生ID(tから始まる)のみ抽出
                    Member member = new Member();
                    member.setMember_id(rs.getString("member_id"));
                    member.setMember_name(rs.getString("member_name"));
                    member.setMember_month(rs.getString("member_month"));
                    member.setMember_password(rs.getString("member_password"));
                    teacher_list.add(member);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (stmt != null) stmt.close(); this.disConnect(); } catch (SQLException e) {}
        }
        return teacher_list;
    }

    // 担任更新用（空文字ならNULLを保存）
    public boolean Teacher_Update(Member member) {
        boolean isUpdate = false;
        try {
            this.connect();
            String sql = "UPDATE member_table SET member_teacherId = ? WHERE member_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            String mainId = member.getMember_teacher_id();
            if (mainId == null || mainId.isEmpty()) {
                ps.setNull(1, java.sql.Types.VARCHAR); // 外部キー制約エラー回避
            } else {
                ps.setString(1, mainId);
            }
            ps.setString(2, member.getMember_id());
            int record = ps.executeUpdate();
            if (record > 0) isUpdate = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { this.disConnect(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return isUpdate;
    }

    // 副担任更新用（空文字ならNULLを保存）
    public boolean SubTeacher_Update(Member member) {
        boolean isUpdate = false;
        try {
            this.connect();
            String sql = "UPDATE member_table SET member_subTeacherId = ? WHERE member_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            String subId = member.getMember_subteacher_id();
            if (subId == null || subId.isEmpty()) {
                ps.setNull(1, java.sql.Types.VARCHAR); // 外部キー制約エラー回避
            } else {
                ps.setString(1, subId);
            }
            ps.setString(2, member.getMember_id());
            int record = ps.executeUpdate();
            if (record > 0) isUpdate = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { this.disConnect(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return isUpdate;
    }
}