import { useEffect, useState } from "react";
import api from "../api";
import ProductsTable from "../ui/Table";
import SnackBar from "../ui/SnackBar";

const ProductsPage = () => {
  const productsHost = import.meta.env.VITE_PRODUCTS_HOST;
  const [productsData, setProductsData] = useState(null);
  const [state, setState] = useState({
    open: false,
    vertical: "top",
    horizontal: "center",
    message: "",
  });

  const { vertical, horizontal, open, message } = state;

  const handleClose = () => {
    setState({ ...state, open: false });
  };

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const response = await api.get(`${productsHost}/products`);
        setProductsData(response.data);
      } catch (error) {
        setState({
          open: true,
          vertical: "top",
          horizontal: "center",
          message: error.message || "An error occurred",
        });
        console.error("Error fetching products:", error);
      }
    };
    fetchProducts();
  }, [productsHost]);

  return (
    <div>
      {productsData ? (
        <ProductsTable products={productsData} />
      ) : (
        <SnackBar
          open={open}
          vertical={vertical}
          horizontal={horizontal}
          message={message}
          handleClose={handleClose}
        />
      )}
    </div>
  );
};

export default ProductsPage;
