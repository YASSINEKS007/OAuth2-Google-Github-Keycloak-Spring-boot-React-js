const KeycloakInitOptions = {
  onLoad: "login-required",
  checkLoginIframe: true,
  silentCheckSsoRedirectUri: window.location.origin + "/src/assets/silent-check-sso.html",
};
export default KeycloakInitOptions;
