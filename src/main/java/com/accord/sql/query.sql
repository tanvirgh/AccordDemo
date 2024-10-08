SELECT u.id, u.firstName,u.lastName, u.email, r.name
FROM user u
JOIN user_roles ur ON u.user_id = ur.user_id
JOIN role r ON ur.role_id = r.role_id;