import React from 'react';

// Contexts
import AppProvider from './contexts';

// Components
import Header from './components/Header';

// Routes
import Routes from './routes';

// Styles
import GlobalStyles from './styles/global';

const App: React.FC = () => {
  return (
    <AppProvider>
      <Header />
      <Routes />
      <GlobalStyles />
    </AppProvider>
  );
}

export default App;