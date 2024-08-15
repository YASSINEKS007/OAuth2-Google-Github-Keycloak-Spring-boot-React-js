import { useKeycloak } from "@react-keycloak/web";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Nav from "./components/Nav";
import HomePage from "./pages/HomePage";
import SecuredPage from "./pages/SecuredPage";
import NotAuthorizedPage from "./pages/NotAuthorizedPage";
import ProductsPage from "./pages/ProductsPage";

const App = () => {
  const { keycloak, initialized } = useKeycloak();

  if (!initialized) {
    return (
      <div className="flex items-center justify-center min-h-screen">
        Loading...
      </div>
    );
  }

  const isAuthenticated = keycloak.authenticated;
  localStorage.setItem("access", keycloak.token);
  localStorage.setItem("refresh", keycloak.refreshToken);

  return (
    <div>
      <Nav />
      <BrowserRouter>
        <Routes>
          <Route
            exact
            path="/"
            element={<HomePage />}
          />
          <Route
            path="/secured"
            element={isAuthenticated ? <SecuredPage /> : <NotAuthorizedPage />}
          />
          <Route
            path="/products"
            element={isAuthenticated ? <ProductsPage /> : <NotAuthorizedPage />}
          />
        </Routes>
      </BrowserRouter>
    </div>
  );
};

export default App;
