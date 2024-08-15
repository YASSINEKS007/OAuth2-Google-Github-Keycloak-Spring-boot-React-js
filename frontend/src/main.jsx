import { ReactKeycloakProvider } from "@react-keycloak/web";
import { createRoot } from "react-dom/client";
import App from "./App.jsx";
import "./index.css";
import keycloak from "./keycloak";
import KeycloakInitOptions from "./keycloakInitOptions.js";

const keycloakEventHandler = (event) => {
  if (event === "onTokenExpired") {
    keycloak
      .updateToken(5)
      .then((refreshed) => {
        if (refreshed) {
          localStorage.setItem("access", keycloak.token);
          localStorage.setItem("refresh", keycloak.refreshToken);
        } else {
          console.warn("Token not refreshed, will need to re-login");
        }
      })
      .catch(() => {
        console.error("Failed to refresh token");
      });
  }
};

createRoot(document.getElementById("root")).render(
  <ReactKeycloakProvider
    authClient={keycloak}
    initOptions={KeycloakInitOptions}
    onEvent={keycloakEventHandler}
  >
    <App />
  </ReactKeycloakProvider>
);
