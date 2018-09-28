update
  authorized_clients
set
  token_value = /*accessToken.tokenValue*/'',
  issued_at = /*accessToken.issuedAt*/'2018-01-01 00:00:00',
  expires_at = /*accessToken.expiresAt*/'2018-01-01 00:00:00'
where principal_name = /*id.principalName*/'' and registration_id = /*id.registrationId*/''
