import Snackbar from "@mui/material/Snackbar";
import Box from "@mui/material/Box";
import Alert from "@mui/material/Alert";

export default function SnackBar({ open, vertical, horizontal, message, handleClose }) {
  return (
    <Box sx={{ width: 500 }}>
      <Snackbar
        anchorOrigin={{ vertical, horizontal }}
        open={open}
        autoHideDuration={3000}
        onClose={handleClose} // Close the Snackbar when the Alert is closed
        key={vertical + horizontal}
      >
        <Alert onClose={handleClose} severity="error" variant="filled" sx={{ width: "100%" }}>
          {message}
        </Alert>
      </Snackbar>
    </Box>
  );
}
