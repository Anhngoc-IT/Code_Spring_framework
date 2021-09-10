package VTI.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import VTI.Utils.HibernateUtils;
import VTI.entity.Department;
import VTI.entity.Parameters;

@Repository   
public class DepartmentRepository implements IDepartmentRepository {

	// khao báo 1 cái thuộc tính hibernateUtils 
	HibernateUtils hibernateUtils = HibernateUtils.getInstance();
	
	@Override
	public List<Department> getAllDepartment(Parameters parameters) {
		
		Session session = null;
		// get session
	    session = hibernateUtils.openSession();
//			
//			// nếu seach mà rỗng , thì sẽ để rỗng, == null
//			if(parameters.search.isEmpty()) {
//				parameters.search = "";
//			}
//			Query<Department> query = session.createQuery("FROM Department "
//					+ "WHERE name like " + "'%" + parameters.search + "%'" );
	    
	    // lấy ra 1 ds department
	        Criteria cr = session.createCriteria(Department.class);
			
	        // check điều kiện, tạo 1 câu lệnh where, ge ss lớn hơn minID
			if(parameters.minId > 0) {
				cr.add(Restrictions.ge("id", parameters.minId));
			}
			
			//<=
			if(parameters.maxId > 0) {
				cr.add(Restrictions.le("id", parameters.maxId));
			}
			
			// kiểm tra xem seach có tồn tại hay k, search là string
			if(parameters.search != null && !parameters.search.isEmpty()) {
				
				// ilike : chữ viết hoa, thường
				cr.add(Restrictions.ilike("name","%" + parameters.search + "%"));
			}
			//Sắp xếp theo field + typeSort : 
			if(parameters.typeSort != null && parameters.field != null) {
				if(parameters.typeSort.equals("ASC")) {
					cr.addOrder(Order.asc(parameters.field));
				}else {
					cr.addOrder(Order.desc(parameters.field));
				}
				
			}
			// phân trang dựa trên 2 thuộc tinh page và pageSize :
			if(parameters.page > 0 && parameters.pageSize > 0) {
				
				// công thức : page -1 * pageSize : ra vị trí phnf tử đầu tiên
				cr.setFirstResult((parameters.page -1) * parameters.pageSize);
				
				// số lượng pt của 1 page
				cr.setMaxResults(parameters.pageSize);
			}
			return cr.list();
}

	@Override
	public Department getDepartmentById(short id) {
		
		// get Session
		Session session = null;
		
		try {
			// get Sess
			
			session = hibernateUtils.openSession();
			
			// get Department by id
			Department department = session.get(Department.class, id);
			
			return department;
			
		} finally {
			if(session != null) {
				session.close();
			}
		}
		
	}

	
	@Override
	public void CreateDepartment(Department department) {
	
		Session session = null;
		
		try {
			session = hibernateUtils.openSession();
			
			session.beginTransaction();
			// create
			session.save(department);
			
			session.getTransaction().commit();
			
		} finally {
			if(session != null) {
				session.close();
			}
		}
		
	}

	
	@Override
	public void UpdateDepartment(short id, String name) {
		
		Session session = null;
		
		try {
			
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			Department department = (Department) session.load(Department.class, id);
			
			// update
			
			department.setName(name);
			session.update(department);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
	}

	
	@Override
	public void DeleteDepartment(short id) {
		 
		Session session = null;
		try {
			
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			// get department
			Department department = (Department) session.load(Department.class, id);
			
			// delete
			session.delete(department);
			
			session.getTransaction().commit();
		} finally {
			
			if (session != null) {
				session.close();
			}
		}
		
	}

	
}
