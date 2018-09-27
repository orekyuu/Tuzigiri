select /*%expand*/*
from authorized_clients
where principal_name = /*authorizedClientId.principalName*/'' and registration_id = /*authorizedClientId.registrationId*/'';
