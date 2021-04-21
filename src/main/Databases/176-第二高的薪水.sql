编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
例如上述 Employee 表，SQL查询应该返回 200 作为第二高的薪水。如果不存在第二高的薪水，那么查询应返回 null。

+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+

# 使用临时表方式，将不同的薪资按降序排序，然后使用LIMIT字句获得第二高的薪资，如果没有第二高的需要方法NULL，所以使用IFNULL语句进行嵌套
SELECT IFNULL((
	SELECT DISTINCT Salary FROM Employee ORDER BY Salary DESC LIMIT 1,1,NULL)) 
AS SecondHighestSalary

IFNULL(a,b)函数解释：

如果value1不是空，结果返回a

如果value1是空，结果返回b