# Rakuten-kai

### How to create a development env on Eclipse-Che
1. Open Workspaces page in Eclipse Che
2. Click "Add Workspace" button, then it New Workspace page appears
3. Click "Create & Proceed Editing" (at next triangle mark next to "CREATE & OPEN" button), then Workspaces page appears
4. Click "Devfile" tab, and paste [rakutenkai-presentation.json](rakutenkai-presentation.json) into "Workspace" textarea, after that "Success" message appears
5. Click "Open", then a workspace opens
6. Click "View" -> "My Workspace" on the menu, then "MY WORKSPACE" appears
7. Click "maven build", then the rakutenkai project will be built
8. Click "8080/tcp", then a instant server page appears
9. Get IP addresses of the instant server, and register them into a white-list of Geolocation API (ipinfodb.com)