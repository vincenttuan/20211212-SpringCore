select j.jid, j.jname, j.eid, 
	e.eid as emp_eid, e.ename as emp_ename, e.age as emp_age, e.createtime as emp_createtime
from job j left outer join emp e on e.eid = j.eid
