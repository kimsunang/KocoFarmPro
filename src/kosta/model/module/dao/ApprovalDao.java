package kosta.model.module.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.mapper.module.ApprovalMapper;
import kosta.model.module.vo.ApprovalDraft;
import kosta.model.module.vo.ApprovalForm;
import kosta.model.module.vo.ApprovalFormSearch;
import kosta.model.module.vo.ApprovalVacation;
import kosta.model.module.vo.Employee;

public class ApprovalDao {

   public static ApprovalDao dao = new ApprovalDao();

   public static ApprovalDao getInstance() {
      return dao;
   }

   public SqlSessionFactory getSqlSessionFactory() {
      String resource = "mybatis-config.xml";
      InputStream in = null;
      try {
         in = Resources.getResourceAsStream(resource);

      } catch (Exception e) {
         e.printStackTrace();
      }

      return new SqlSessionFactoryBuilder().build(in);
   }
   
   /*기안서 기본 값 insert*/
   public int insertDraft(ApprovalDraft draft) {
      int re = -1;
      SqlSession sqlSession = getSqlSessionFactory().openSession();

      try {
         re = sqlSession.getMapper(ApprovalMapper.class).insertDraft(draft);
         if (re > 0) {
            sqlSession.commit();
         } else {
            sqlSession.rollback();
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         sqlSession.close();
      }

      return re;
   }

   /*휴가신청서 insert*/
   public int insertVacation(ApprovalVacation vacation) {
      int re = -1;
      SqlSession sqlSession = getSqlSessionFactory().openSession();

      try {
         re = sqlSession.getMapper(ApprovalMapper.class).insertVacation(vacation);
         if (re > 0) {
            sqlSession.commit();
         } else {
            sqlSession.rollback();
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         sqlSession.close();
      }

      return re;
   }

   /*양식 리스트 출력*/
   public List<ApprovalForm> listForm(ApprovalFormSearch search) {
      SqlSession sqlSession = getSqlSessionFactory().openSession();
      List<ApprovalForm> list = null;

      try {
         list = sqlSession.getMapper(ApprovalMapper.class).listForm(search);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         sqlSession.close();
      }
      return list;
   }

   /*전체 기안서 출력*/
   public List<ApprovalDraft> listDraft() {
      SqlSession sqlSession = getSqlSessionFactory().openSession();
      List<ApprovalDraft> list = null;

      try {
         list = sqlSession.getMapper(ApprovalMapper.class).listDraft();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         sqlSession.close();
      }
      return list;

   }

   /*각 양식별 기안서 출력*/
   public ApprovalForm getDetailForm(int formId) {
      SqlSession sqlSession = getSqlSessionFactory().openSession();
      ApprovalForm form = null;

      try {
         form = sqlSession.getMapper(ApprovalMapper.class).getDetailForm(formId);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         sqlSession.close();
      }
      return form;
   }
   
   /*직원 정보 불러오기*/
   public Employee getEmployee(int empId){
      SqlSession sqlSession = getSqlSessionFactory().openSession();
      Employee emp = null;

      try {
         emp = sqlSession.getMapper(ApprovalMapper.class).getEmployee(empId);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         sqlSession.close();
      }
      return emp;
   }
   
   /* 기안서 번호 받아오기  */
   public int getDraftId(){
      SqlSession sqlSession = getSqlSessionFactory().openSession();
      int draftId = -1;
      
      try {
         draftId = sqlSession.getMapper(ApprovalMapper.class).getDraftId();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         sqlSession.close();
      }
      return draftId;
   }
   
   /*기본 기안서 정보 가져오기*/
   public ApprovalDraft getDraft(int draftId){
      SqlSession sqlSession = getSqlSessionFactory().openSession();
      ApprovalDraft draft = null;

      try {
         draft = sqlSession.getMapper(ApprovalMapper.class).getDraft(draftId);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         sqlSession.close();
      }
      return draft;
   }
   /*휴가 신청서 정보 가져오기*/
   public ApprovalVacation getVacation(int draftId){
      SqlSession sqlSession = getSqlSessionFactory().openSession();
      ApprovalVacation vacation = null;
      
      try {
         vacation = sqlSession.getMapper(ApprovalMapper.class).getVacation(draftId);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         sqlSession.close();
      }
      return vacation;
      
   }
}