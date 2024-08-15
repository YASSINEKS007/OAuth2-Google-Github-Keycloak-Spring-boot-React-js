const NotAuthorizedPage = () => {
  return (
    <div className="flex flex-col items-center justify-center min-h-screen bg-gray-100">
      <h1 className="text-4xl font-bold text-red-500 mb-4">Not Authorized</h1>
      <p className="text-gray-600 text-lg">
        You do not have permission to access this page.
      </p>
    </div>
  );
};

export default NotAuthorizedPage;
