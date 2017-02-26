-- FUNCTIONS
CREATE FUNCTION public.user_roles(userN VARCHAR(10), roleN VARCHAR(10))
  RETURNS VOID
LANGUAGE plpgsql
AS $$
DECLARE
  user_id UUID;
  role_id UUID;
BEGIN
  user_id := (SELECT id
              FROM users
              WHERE users.username = userN);
  role_id := (SELECT id
              FROM roles
              WHERE roles.name = roleN);
  INSERT INTO user_roles (user_id, role_id) VALUES (user_id, role_id);
END
$$;